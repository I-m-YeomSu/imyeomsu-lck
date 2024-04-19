package imyeom_lck.match_schedule.service.inter;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;
import imyeom_lck.match_schedule.domain.dto.NextMatchResponseDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;

public interface MatchScheduleService {



    List<MatchesResponseDTO> getAllMatchesByRedis() throws JsonProcessingException;
    List<MatchesResponseDTO> getAllMatchesByRdb() throws JsonProcessingException;

    List<MatchesViewResponseDTO> getAllMatcheSchedule() throws JsonProcessingException;

}
