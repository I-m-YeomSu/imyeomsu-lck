package imyeom_lck.match_schedule.dummy;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.team.domain.entity.Team;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class DummyMatchSchedule {

    public static MatchSchedule createDummyMatchSchedule(String memberName, String password, String phoneNumber, String loginId) {
        MatchSchedule matchSchedule = new MatchSchedule();

        member.setName(memberName);
        member.setPassword(password);
        member.setPhoneNumber(phoneNumber);
        member.setLoginId(loginId);
        return member;


        private Long matchScheduleId;
        private Team homeTeam;
        private Team awayTeam;
        private LocalDateTime matchDate;
        private boolean matchResult;
        private boolean isShowdown;
        return matchSchedule

    }
}
