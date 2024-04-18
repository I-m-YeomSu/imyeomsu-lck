package imyeom_lck.match_schedule.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JpaMatchScheduleRepository extends JpaRepository<MatchSchedule, Long> {

    List <MatchSchedule> findAll();

}
