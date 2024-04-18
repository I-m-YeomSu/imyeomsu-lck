package imyeom_lck.match_schedule.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchesViewResponseDTO {

    private LocalDateTime matchDate;
    private String matchTitle;
    private String homeTeamScore;
    private String awayTeamScore;
    private String homeTeamName;
    private String homeTeamLogo;
    private String awayTeamName;
    private String awayTeamLogo;

}
