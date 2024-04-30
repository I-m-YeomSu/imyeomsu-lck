package imyeom_lck.match_schedule.service.inter;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;

import java.util.List;

public interface MatchScheduleService {



    List<MatchesResponseDTO> getAllMatchesByRedis() throws JsonProcessingException;
    List<MatchesResponseDTO> getAllMatchesByRdb() throws JsonProcessingException;
    List<MatchesViewResponseDTO> getAllMatchSchedule() throws JsonProcessingException;


}
