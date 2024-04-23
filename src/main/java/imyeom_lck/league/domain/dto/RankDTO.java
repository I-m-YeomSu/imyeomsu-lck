package imyeom_lck.league.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RankDTO {
    private String logo;
    private String teamName;
    private int win;
    private int lose;
    private int difference;
    private String winrate;
    private String kda;
    private int killCount;
    private int deathCount;
    private int assistCount;
}
