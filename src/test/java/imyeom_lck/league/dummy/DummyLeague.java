package imyeom_lck.league.dummy;

import imyeom_lck.league.domain.entity.League;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.team.domain.entity.Team;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

public class DummyLeague {
    public static League dummy(Team team, MatchSchedule matchSchedule){
        return League.builder()
                .team(team)
                .matchSchedule(matchSchedule)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(7))
                .build();
    }
}
