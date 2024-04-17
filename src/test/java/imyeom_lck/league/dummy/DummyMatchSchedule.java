package imyeom_lck.league.dummy;

import imyeom_lck.league.domain.entity.League;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.team.domain.entity.Team;

import java.time.LocalDateTime;

public class DummyMatchSchedule {
    public static MatchSchedule dummy(Long id, String title){
        return MatchSchedule.builder()
                .matchId(id)
                .matchTitle(title)
                .build();
    }
}
