package imyeom_lck.league.dummy;

import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.domain.entity.League;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.team.domain.entity.Team;

import java.time.LocalDateTime;

public class DummyRankDTO {

    public static RankDTO dummy(String name, String logo, int win){
        return RankDTO.builder()
                .name(name)
                .logo(logo)
                .win(win)
                .build();
    }

}
