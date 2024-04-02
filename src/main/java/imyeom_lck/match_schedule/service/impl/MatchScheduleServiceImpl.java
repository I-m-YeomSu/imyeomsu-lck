package imyeom_lck.match_schedule.service.impl;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.persistence.jpa.JpaMatchScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import imyeom_lck.match_schedule.service.inter.MatchScheduleService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchScheduleServiceImpl implements MatchScheduleService {

    private final JpaMatchScheduleRepository matchRepository;

    public List<MatchesResponseDTO> getAllMatches() {

        List<MatchesResponseDTO> matchesResponseDTOS = new ArrayList<>();
        List<MatchSchedule> matchSchedules = matchRepository.findAll();

        for(MatchSchedule matchSchedule : matchSchedules) {
            matchesResponseDTOS.add(new MatchesResponseDTO(
                    matchSchedule.getHomeTeam(),
<<<<<<< HEAD
                    matchSchedule.getAwayTeam(),
=======
//                    matchSchedule.getAwayTeam().getTeam(),
>>>>>>> ea8f5c012d0fe60b0e1fdd4fae393c33ea668e3a
                    matchSchedule.getMatchDate().toString(),
                    matchSchedule.isMatchResult(),
                    matchSchedule.isShowdown())
            );
        }

        return matchesResponseDTOS;
    }
}
