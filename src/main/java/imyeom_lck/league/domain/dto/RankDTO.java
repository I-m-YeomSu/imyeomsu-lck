package imyeom_lck.league.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RankDTO {
    private String logo;
    private String TeamName;
    private int win;
    private int lose;
    private int difference;
    private String winrate;
    private String kda;
    private int killcount;
    private int deathcount;
    private int assistcount;
}
