package imyeom_lck.match_schedule.dummy;

import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.team.domain.entity.Team;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class DummyMatchSchedule {


    public static MatchSchedule createDummyMatchSchedule(Long homeTeam,
                                                         Long awayTeam,
                                                         LocalDateTime matchDate,
                                                         boolean matchResult,
                                                         boolean isShowdown) {

        return MatchSchedule.createMatchSchedule(homeTeam, awayTeam, matchDate, matchResult, isShowdown);
    }

}
