package imyeom_lck.match_schedule.domain.dto;

import imyeom_lck.team.domain.entity.Team;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MatchesResponseDTO {

    private Long homeTeam;
    private Long awayTeam;
    private String matchDate;
    private boolean matchResult;
    private boolean isShowdown;

}
