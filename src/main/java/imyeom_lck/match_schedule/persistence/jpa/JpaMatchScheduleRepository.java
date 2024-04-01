package imyeom_lck.match_schedule.persistence.jpa;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;

import java.util.List;

public interface JpaMatchScheduleRepository extends JpaRepository<MatchSchedule, Long> {

    List <MatchSchedule> findAll();
}
