package imyeom_lck.predict.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;
import imyeom_lck.match_schedule.persistence.jpa.JpaMatchScheduleRepository;
import imyeom_lck.predict.service.inter.PredictService;
import imyeom_lck.predict.service.inter.VotedUserService;
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
public class VotedUserServiceImple implements VotedUserService {

    private final RedisTemplate<String, String> predictAllRedisTemplate;
    private final ObjectMapper objectMapper;


    public VotedUserServiceImple(@Qualifier("predictAllRedisTemplate") RedisTemplate<String, String> predictAllRedisTemplate,
                                    ObjectMapper objectMapper) {
        this.predictAllRedisTemplate = predictAllRedisTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Long getAllUserCount() throws JsonProcessingException {

        Object countString = predictAllRedisTemplate.opsForValue().get("predict_all_count");

        if (countString == null || countString.toString().isEmpty()) {
            return 0L;
        }

        try {
            Long count = Long.parseLong(countString.toString());
            return count;
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

}
