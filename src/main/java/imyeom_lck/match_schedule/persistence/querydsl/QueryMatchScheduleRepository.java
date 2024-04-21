package imyeom_lck.match_schedule.persistence.querydsl;

import org.springframework.data.domain.Page;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import org.springframework.data.domain.Pageable;

public interface QueryMatchScheduleRepository {

	Page<MatchSchedule> findMatchScheduleByMonth(String month, Pageable pageable);

}
