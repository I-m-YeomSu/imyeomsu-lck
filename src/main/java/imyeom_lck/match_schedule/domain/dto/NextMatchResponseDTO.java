package imyeom_lck.match_schedule.domain.dto;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NextMatchResponseDTO {

    private String homeTeaName;
    private String awayTeamName;
    private String homeTeamLogo;
    private String awayTeamLogo;
    private String matchDate;


    public static NextMatchResponseDTO fromEntity(MatchSchedule matchSchedule) {

        return NextMatchResponseDTO.builder()
            .homeTeaName(matchSchedule.getHomeTeamName())
            .awayTeamName(matchSchedule.getAwayTeamName())
            .homeTeamLogo(matchSchedule.getHomeTeamLogo())
            .awayTeamLogo(matchSchedule.getAwayTeamLogo())
            .matchDate(matchSchedule.getMatchDate()).build();
    }

}
