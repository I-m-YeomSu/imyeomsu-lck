package imyeom_lck.league.service.inter;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface LeagueService {
    List<RankDTO> getrank() throws JsonProcessingException;

    List<RankDTO> ranksort(List<RankDTO> rankList);

    Map<LocalDate, List<NewsDTO>> getnews() throws JsonProcessingException;

}
