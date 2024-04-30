package imyeom_lck.news.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.news.domain.NewsDTO;
import imyeom_lck.news.service.NewsService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {

	private final NewsService newsService;

	@GetMapping("/all-news")
	public String getAllNews(Model model) throws JsonProcessingException {
		//		List<RankDTO> rankList = rankService.getRank();
		//		rankList = rankService.rankSort(rankList);

		Map<LocalDate, List<NewsDTO>> newsMap = newsService.getNews();

		// Localdate 역순으로 newsList 저장
		Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
		reversedNewsMap.putAll(newsMap);

		// Localdate만 역순으로 저장
		List<LocalDate> reversedDates = new ArrayList<>(reversedNewsMap.keySet());

		//		model.addAttribute("ranking", rankList);
		model.addAttribute("newsList", reversedNewsMap);
		model.addAttribute("reversedDates", reversedDates);
		for (LocalDate reversedDate : reversedDates) {
			System.out.println(reversedDate.toString());
		}

		return "news/news";
	}


	@GetMapping("/{newsDate}")
	public String getNewsByDate(@PathVariable(name = "newsDate") String newsDate, Model model) throws
		JsonProcessingException {

		LocalDate date = LocalDate.parse(newsDate, DateTimeFormatter.ISO_DATE);
		Map<LocalDate, List<NewsDTO>> newsMap = newsService.getNews();

		Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
		reversedNewsMap.putAll(newsMap);

		List<LocalDate> reversedDates = new ArrayList<>(reversedNewsMap.keySet());

		// Localdate만 역순으로 저장
		Map<LocalDate, List<NewsDTO>> findNews = new TreeMap<>(Comparator.reverseOrder());

		for (LocalDate localDate : newsMap.keySet()) {
			if (localDate.isEqual(date)){
				findNews.put(localDate,newsMap.get(localDate));
			}
		}

		model.addAttribute("newsList", findNews);
		model.addAttribute("reversedDates", reversedDates);

		return "fragments/news/news-fragment";
	}

}
