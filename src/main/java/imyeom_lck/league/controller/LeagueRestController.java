package imyeom_lck.league.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.league.domain.entity.Rank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LeagueRestController {

    private final RedisTemplate<String, String> matchRankingRedisTemplate;
    private final ObjectMapper objectMapper;

    @GetMapping("/redistest")
    public List<Rank> redistest() throws JsonProcessingException {

        Set<String> keys = matchRankingRedisTemplate.keys("*");
        log.info("from redis:{}", keys);
        List<Rank> rankList = new ArrayList<>();
        for (String key : keys) {
            String json = matchRankingRedisTemplate.opsForValue().get(key);
            Rank rank = objectMapper.readValue(json, Rank.class);
            rankList.add(rank);
        }
        return rankList;
    }
}
