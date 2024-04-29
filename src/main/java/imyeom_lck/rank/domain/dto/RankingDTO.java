package imyeom_lck.rank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RankingDTO {
	//순위를 넣어줄 예정
	private int ranking;
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


	public static RankingDTO fromRankDTO(int ranking,RankDTO rankDTO){
		return RankingDTO.builder()
			.ranking(ranking)
			.logo(rankDTO.getLogo())
			.teamName(rankDTO.getTeamName())
			.win(rankDTO.getWin())
			.lose(rankDTO.getLose())
			.difference(rankDTO.getDifference())
			.winrate(rankDTO.getWinrate())
			.kda(rankDTO.getKda())
			.killCount(rankDTO.getKillCount())
			.deathCount(rankDTO.getDeathCount())
			.assistCount(rankDTO.getAssistCount())
			.build();

	}
}
