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
public class MatchesResponseDTO {

    private String matchDate;
    private String matchTime;
    private String matchState;
    private String matchTitle;
    private String homeTeamScore;
    private String awayTeamScore;
    private String homeTeamName;
    private String homeTeamLogo;
    private String awayTeamName;
    private String awayTeamLogo;

    public static MatchesResponseDTO fromEntity(MatchSchedule matchSchedule) {

        return MatchesResponseDTO.builder()
				.matchDate(matchSchedule.getMatchDate())
				.matchTime(matchSchedule.getMatchTime())
				.matchState(matchSchedule.getMatchState())
				.matchTitle(matchSchedule.getMatchTitle())
                .homeTeamScore(matchSchedule.getHomeTeamScore())
                .awayTeamScore(matchSchedule.getAwayTeamScore())
				.homeTeamName(matchSchedule.getHomeTeamName())
                .awayTeamName(matchSchedule.getAwayTeamName())
				.homeTeamLogo(matchSchedule.getHomeTeamLogo())
				.awayTeamLogo(matchSchedule.getAwayTeamLogo())
				.build();
    }

    public static MatchSchedule toEntity(MatchSchedule matchSchedule) {

        return MatchSchedule.builder()
                .matchDate(matchSchedule.getMatchDate())
                .matchTime(matchSchedule.getMatchTime())
                .matchState(matchSchedule.getMatchState())
                .matchTitle(matchSchedule.getMatchTitle())
                .homeTeamScore(matchSchedule.getHomeTeamScore())
                .awayTeamScore(matchSchedule.getAwayTeamScore())
                .homeTeamName(matchSchedule.getHomeTeamName())
                .awayTeamName(matchSchedule.getAwayTeamName())
                .homeTeamLogo(matchSchedule.getHomeTeamLogo())
                .awayTeamLogo(matchSchedule.getAwayTeamLogo())
                .build();
    }

}
