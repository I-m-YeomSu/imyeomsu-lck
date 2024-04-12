package imyeom_lck.league.service.inter;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;

import java.util.List;

public interface LeagueService {
    List<RankDTO> redistest();

    List<RankDTO> ranksort(List<RankDTO> rankList);

    List<NewsDTO> getnews() throws JsonProcessingException;
}
