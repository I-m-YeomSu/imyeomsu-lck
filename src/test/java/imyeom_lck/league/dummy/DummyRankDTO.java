package imyeom_lck.league.dummy;

import imyeom_lck.rank.domain.dto.RankDTO;

public class DummyRankDTO {

    public static RankDTO dummy(String name, String logo, int win){
        return RankDTO.builder()
                .teamName(name)
                .logo(logo)
                .win(win)
                .build();
    }

}
