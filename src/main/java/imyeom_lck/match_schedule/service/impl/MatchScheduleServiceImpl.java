package imyeom_lck.match_schedule.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import io.lettuce.core.XReadArgs;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class MatchScheduleServiceImpl implements MatchScheduleService {

    private final RedisTemplate<String, String> matchScheduleRedisTemplate;
    private final ObjectMapper objectMapper;

    public MatchScheduleServiceImpl(@Qualifier("matchScheduleRedisTemplate") RedisTemplate<String, String> matchScheduleRedisTemplate,
                                    ObjectMapper objectMapper) {
        this.matchScheduleRedisTemplate = matchScheduleRedisTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<MatchesResponseDTO> getAllMatches() {
        return null;
    }


    @Override
    public List<MatchesResponseDTO> getAllMatcheSchedule() throws JsonProcessingException {
        Set<String> keys = matchScheduleRedisTemplate.keys("*");
        List<MatchesResponseDTO> scheduleList = new ArrayList<>();

        for (String key : keys) {
            Object keys2 = matchScheduleRedisTemplate.opsForValue().get(key);

            String s = objectMapper.writeValueAsString(keys2);

            MatchesResponseDTO matchesResponseDTO = objectMapper.readValue(s, MatchesResponseDTO.class);

            scheduleList.add(matchesResponseDTO);

        }

        return scheduleList;
    }

    @Override
    public List<MatchesResponseDTO> sortAllMatcheSchedule(List<MatchesResponseDTO> scheduleList) throws JsonProcessingException {


        Collections.sort(scheduleList, new Comparator<MatchesResponseDTO>() {
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


}
