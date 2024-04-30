package imyeom_lck.news.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.news.domain.NewsDTO;

public interface NewsService {

	Map<LocalDate, List<NewsDTO>> getNews() throws JsonProcessingException;

	Page<NewsDTO> getPageAllNews(Pageable pageable) throws JsonProcessingException;


}
