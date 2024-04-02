package imyeom_lck.match_schedule.domain.dto;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.team.domain.entity.Team;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchesResponseDTO {

    private Long homeTeam;
    private Long awayTeam;
    private String matchDate;
    private boolean matchResult;
    private boolean isShowdown;


    public static MatchesResponseDTO createMatchResponseDTO(
            Long homeTeam,
            Long awayTeam,
            String matchDate,
            boolean matchResult,
            boolean isShowdown) {

//        return new MatchesResponseDTO(
//                homeTeam,
//                awayTeam,
//                matchDate,
//                matchResult,
//                isShowdown);


        return MatchesResponseDTO.builder()
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .matchDate(matchDate)
                .matchResult(matchResult)
                .isShowdown(isShowdown)
                .build();
    }

}
