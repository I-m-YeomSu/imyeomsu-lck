package imyeom_lck.rank.domain.dto;

import imyeom_lck.rank.domain.entity.Rank;
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


    public static RankDTO fromEntity(Rank rank){
        return RankDTO.builder()
            .logo(rank.getLogo())
            .teamName(rank.getTeamName())
            .win(rank.getWin())
            .lose(rank.getLose())
            .difference(Integer.parseInt(rank.getDifference()))
            .winrate(rank.getWinrate())
            .kda(String.valueOf(rank.getKda()))
            .killCount(rank.getKillCount())
            .deathCount(rank.getDeathCount())
            .assistCount(rank.getAssistCount())
            .build();
    }
}
