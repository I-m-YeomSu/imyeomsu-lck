package imyeom_lck.league.service.inter;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.league.domain.dto.NewsDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LeagueService {


    Map<LocalDate, List<NewsDTO>> getNews() throws JsonProcessingException;

    Page<NewsDTO> getPageAllNews(Pageable pageable) throws JsonProcessingException;


}
