package imyeom_lck.match_schedule.service.inter;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryMatchScheduleService {
    List<MatchesResponseDTO> getAllMatchScheduleByMonth(String month, Pageable pageable);

}
