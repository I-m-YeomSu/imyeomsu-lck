package imyeom_lck.rank.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.rank.domain.dto.RankingDTO;
import imyeom_lck.rank.domain.entity.Rank;
import imyeom_lck.rank.persistence.JpaRankRepository;

@Service
@Transactional(readOnly = true)
public class RankServiceImpl implements RankService{

	private final JpaRankRepository rankRepository;

	private final RedisTemplate<String, String> matchRankingRedisTemplate;
	private final ObjectMapper objectMapper;

	public RankServiceImpl(JpaRankRepository rankRepository, @Qualifier("matchRankingRedisTemplate") RedisTemplate<String, String> matchRankingRedisTemplate,
		ObjectMapper objectMapper) {
		this.rankRepository = rankRepository;
		this.matchRankingRedisTemplate = matchRankingRedisTemplate;
		this.objectMapper = objectMapper;
	}

	public List<RankDTO> getRank() throws JsonProcessingException {
		Set<String> keys = matchRankingRedisTemplate.keys("*");
		List<RankDTO> rankList = new ArrayList<>();

		for (String key : keys) {
			Object keys2 = matchRankingRedisTemplate.opsForValue().get(key);
			String s = objectMapper.writeValueAsString(keys2);
			RankDTO rankDTO = objectMapper.readValue(s, RankDTO.class);
			rankList.add(rankDTO);

		}

		return rankList;
	}

	/**
	 * 해당 list의 랭킹을 승수를 기준으로 순위대로 정렬합니다.
	 * 이때 순위 필드는 존재하지 않아서 getRankingDto()를 이용해서 이를 가져와야 합니다.
	 * */
	public List<RankDTO> rankSort(List<RankDTO> rankList) {
		Collections.sort(rankList, new Comparator<RankDTO>() {
			@Override
			public int compare(RankDTO r1, RankDTO r2) {
				if (r1.getWin() != r2.getWin()) {
					return r2.getWin() - r1.getWin(); // 승수가 큰 순서대로 정렬
				} else {
					return r2.getDifference() - r1.getDifference(); // 승수가 같으면 차이가 큰 순서대로 정렬
				}
			}
		});

		return rankList;
	}

	/*
	 * 순위대로 정렬 해놓은 랭킹 요소를 이용해서 순위까지 포함하는 DTO를 만들어 반환합니다.
	 * */
	public List<RankingDTO> getRankingDto(List<RankDTO> rankList){
		List<RankingDTO> result = new ArrayList<>();
		for (int i= 0; i < rankList.size(); i++){
			result.add(RankingDTO.fromRankDTO(i+1, rankList.get(i)));
		}
		return result;
	}

	@Override
	public List<RankDTO> getRanks() {

		List<Rank> all = rankRepository.findAll();
		List<RankDTO> result = new ArrayList<>();
		for (Rank rank : all) {
			result.add(RankDTO.fromEntity(rank));
		}

		return result;
	}

}
