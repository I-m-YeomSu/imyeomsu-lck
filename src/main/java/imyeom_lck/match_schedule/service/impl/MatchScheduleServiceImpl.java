package imyeom_lck.match_schedule.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.persistence.jpa.JpaMatchScheduleRepository;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;

import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;
import imyeomsu.lck.common_utils.utils.StringHandlingUtils;
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
    private final JpaMatchScheduleRepository jpaMatchScheduleRepository;


    public MatchScheduleServiceImpl(@Qualifier("matchScheduleRedisTemplate") RedisTemplate<String, String> matchScheduleRedisTemplate,
                                    ObjectMapper objectMapper, JpaMatchScheduleRepository jpaMatchScheduleRepository) {
        this.matchScheduleRedisTemplate = matchScheduleRedisTemplate;
        this.objectMapper = objectMapper;
		this.jpaMatchScheduleRepository = jpaMatchScheduleRepository;
	}

    @Override
    public List<MatchesResponseDTO> getAllMatchesByRedis() throws JsonProcessingException {
        Set<String> keys = matchScheduleRedisTemplate.keys("*");
        log.info("서비스 - 여기를 오고");

        List<MatchesResponseDTO> dtos = new ArrayList<>();

        log.info("{}",keys.size());
        for (String key : keys) {
            Object s = matchScheduleRedisTemplate.opsForValue().get(key);

            MatchesResponseDTO matchesResponseDTO = objectMapper.convertValue(s, MatchesResponseDTO.class);
            matchesResponseDTO.setMatchDate(StringHandlingUtils.extractDate(matchesResponseDTO.getMatchDate()));

            log.info(matchesResponseDTO.getMatchDate());

            dtos.add(matchesResponseDTO);
        }


        return dtos;
    }

    @Override
    public List<MatchesResponseDTO> getAllMatchesByRdb() throws JsonProcessingException {

        List<MatchSchedule> entity = jpaMatchScheduleRepository.findAll();
        List<MatchesResponseDTO> dtos = new ArrayList<>();

        for (MatchSchedule matchSchedule : entity) {
            MatchesResponseDTO matchesResponseDTO = MatchesResponseDTO.fromEntity(matchSchedule);
            dtos.add(matchesResponseDTO);
        }

        return dtos;
    }

    @Override
    public List<MatchesViewResponseDTO> getAllMatchSchedule() throws JsonProcessingException {
        Set<String> keys = matchScheduleRedisTemplate.keys("*");

        List<MatchesViewResponseDTO> matches = new ArrayList<>();

        for (String key : keys) {
            Object keys2 = matchScheduleRedisTemplate.opsForValue().get(key);

            String s = objectMapper.writeValueAsString(keys2);
            objectMapper.readValue(s, MatchesViewResponseDTO.class);

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
