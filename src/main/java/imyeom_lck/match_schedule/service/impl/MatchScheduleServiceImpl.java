package imyeom_lck.match_schedule.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
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
    public List<MatchesViewResponseDTO> getAllMatcheSchedule() throws JsonProcessingException {
        Set<String> keys = matchScheduleRedisTemplate.keys("*");
        List<MatchesViewResponseDTO> matches = new ArrayList<>();

        for (String key : keys) {
            Object keys2 = matchScheduleRedisTemplate.opsForValue().get(key);

            String s = objectMapper.writeValueAsString(keys2);

            JsonNode node = objectMapper.readTree(s);
            String matchDate = node.get("matchDate").asText();
            String matchTime = node.get("matchTime").asText();
            // 숫자와 일부 특수 문자('-')만 남기고 다른 문자 제거
            matchDate = matchDate.replaceAll("[^0-9\\-]", "");
            // 년도, - 더해주기
            matchDate = "2024-" + matchDate.substring(0, 2) + "-" + matchDate.substring(2, 4);
            // ISO-8601 형식에 맞게 조정
            String isoDateTime = matchDate + "T" + matchTime;
            // LocalDateTime으로 변환
            LocalDateTime dateTime = LocalDateTime.parse(isoDateTime);

            MatchesViewResponseDTO match = MatchesViewResponseDTO.builder()
                            .matchDate(dateTime)
                            .matchTitle(node.get("matchTitle").asText())
                            .homeTeamScore(node.get("homeTeamScore").asText())
                            .awayTeamScore(node.get("awayTeamScore").asText())
                            .homeTeamName(node.get("homeTeamName").asText())
                            .homeTeamLogo(node.get("homeTeamLogo").asText())
                            .awayTeamName(node.get("awayTeamName").asText())
                            .awayTeamLogo(node.get("awayTeamLogo").asText())
                            .build();

            matches.add(match);
        }
        matches.sort(Comparator.comparing(MatchesViewResponseDTO::getMatchDate));

        return matches;
    }


}
