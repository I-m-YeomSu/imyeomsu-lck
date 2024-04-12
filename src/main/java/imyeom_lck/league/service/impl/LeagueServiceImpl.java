package imyeom_lck.league.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LeagueServiceImpl implements LeagueService {

    private final RedisTemplate<String, String> matchRankingRedisTemplate;
    private final RedisTemplate<String, String> newsRedisTemplate;
    private final ObjectMapper objectMapper;

    public LeagueServiceImpl(@Qualifier("matchRankingRedisTemplate") RedisTemplate<String, String> matchRankingRedisTemplate,
                             @Qualifier("newsRedisTemplate") RedisTemplate<String, String> newsRedisTemplate,
                             ObjectMapper objectMapper) {
        this.matchRankingRedisTemplate = matchRankingRedisTemplate;
        this.newsRedisTemplate = newsRedisTemplate;
        this.objectMapper = objectMapper;
    }

    public List<RankDTO> getrank() throws JsonProcessingException {
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

    public List<RankDTO> ranksort(List<RankDTO> rankList){

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

    @Override
    public Map<LocalDate, List<NewsDTO>> getnews() throws JsonProcessingException {
        Set<String> keys = newsRedisTemplate.keys("*");
        Map<LocalDate, List<NewsDTO>> newsMap = new TreeMap<>(Comparator.reverseOrder());

        for (String key : keys) {
            Object keys2 = newsRedisTemplate.opsForValue().get(key);
            String s = objectMapper.writeValueAsString(keys2);
            NewsDTO newsDTO = objectMapper.readValue(s, NewsDTO.class);

            // 현재 날짜에 해당하는 리스트 가져오기
            List<NewsDTO> newsList = newsMap.getOrDefault(newsDTO.getDate(), new ArrayList<>());
            // 뉴스 추가
            newsList.add(newsDTO);
            // 리스트 정렬
            newsList.sort(Comparator.comparingInt(NewsDTO::getIndex));
            // 리스트 갱신
            newsMap.put(newsDTO.getDate(), newsList);
        }

        return newsMap;
    }



}
