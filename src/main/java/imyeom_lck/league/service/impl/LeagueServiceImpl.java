package imyeom_lck.league.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import imyeom_lck.rank.domain.dto.RankingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class LeagueServiceImpl implements LeagueService {


    private final RedisTemplate<String, String> newsRedisTemplate;
    private final ObjectMapper objectMapper;

    public LeagueServiceImpl(
        @Qualifier("newsRedisTemplate") RedisTemplate<String, String> newsRedisTemplate,
        ObjectMapper objectMapper) {
        this.newsRedisTemplate = newsRedisTemplate;
        this.objectMapper = objectMapper;
    }


    @Override
    public Map<LocalDate, List<NewsDTO>> getNews() throws JsonProcessingException {
        Map<LocalDate, List<NewsDTO>> newsMap = getNewsMap();
        return newsMap;
    }

    /*
    * page를 사용한 뉴스 크롤링 데이터를 찾아오는 메서드입니다.
    * */
    @Override
    public Page<NewsDTO> getPageAllNews(Pageable pageable) throws JsonProcessingException {
        List<NewsDTO> list = new ArrayList<>();

        Map<LocalDate, List<NewsDTO>> newsMap = getNewsMap();
        for (List<NewsDTO> value : newsMap.values()) {
            for (NewsDTO newsDTO : value) {
                list.add(newsDTO);
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }

    private Map<LocalDate, List<NewsDTO>> getNewsMap() throws JsonProcessingException {
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
