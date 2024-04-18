package imyeom_lck.match_schedule.persistence.querydsl;

import org.springframework.data.domain.Page;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;

public interface QueryMatchScheduleRepository {

	Page<MatchesResponseDTO> findMatchScheduleByMonth(String month);

}
