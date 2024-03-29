package imyeom_lck.match_schedule.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;

public interface JpaMatchScheduleRepository extends JpaRepository<MatchSchedule, Long> {


}
