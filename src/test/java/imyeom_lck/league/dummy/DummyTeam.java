package imyeom_lck.league.dummy;

import imyeom_lck.league.domain.entity.League;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.team.domain.entity.Team;

import java.time.LocalDateTime;

public class DummyTeam {

    public static Team dummy(Long id, String name){
        return Team.builder()
                .team(id)
                .teamName(name)
                .build();
    }

}

