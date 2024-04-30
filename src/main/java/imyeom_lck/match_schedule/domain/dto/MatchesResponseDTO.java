package imyeom_lck.match_schedule.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MatchesResponseDTO implements Serializable {
	@JsonProperty(value = "matchDate")
    private String matchDate;
	@JsonProperty(value = "matchTime")
    private String matchTime;
	@JsonProperty(value = "matchState")
    private String matchState;
	@JsonProperty(value = "matchTitle")
    private String matchTitle;
	@JsonProperty(value = "homeTeamScore")
    private String homeTeamScore;
	@JsonProperty(value = "awayTeamScore")
    private String awayTeamScore;
	@JsonProperty(value = "homeTeamName")
    private String homeTeamName;
	@JsonProperty(value = "homeTeamLogo")
    private String homeTeamLogo;
	@JsonProperty(value = "awayTeamName")
    private String awayTeamName;
	@JsonProperty(value = "awayTeamLogo")
    private String awayTeamLogo;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public MatchesResponseDTO() {
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public MatchesResponseDTO(@JsonProperty(value = "matchDate") String matchDate, @JsonProperty(value = "matchTime") String matchTime,
		@JsonProperty(value = "matchState") String matchState, @JsonProperty(value = "matchTitle") String matchTitle,
		@JsonProperty(value = "homeTeamScore") String homeTeamScore, @JsonProperty(value = "awayTeamScore") String awayTeamScore,
		@JsonProperty(value = "homeTeamName") String homeTeamName, @JsonProperty(value = "homeTeamLogo") String homeTeamLogo,
		@JsonProperty(value = "awayTeamName") String awayTeamName, @JsonProperty(value = "awayTeamLogo") String awayTeamLogo) {
		this.matchDate = matchDate;
		this.matchTime = matchTime;
		this.matchState = matchState;
		this.matchTitle = matchTitle;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.homeTeamName = homeTeamName;
		this.homeTeamLogo = homeTeamLogo;
		this.awayTeamName = awayTeamName;
		this.awayTeamLogo = awayTeamLogo;
	}

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
