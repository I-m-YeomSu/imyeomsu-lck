package imyeom_lck.match_schedule.service.inter;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;

import java.util.List;

public interface MatchScheduleService {
    List<MatchesResponseDTO> getAllMatches();

}
