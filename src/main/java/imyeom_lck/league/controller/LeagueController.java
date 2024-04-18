package imyeom_lck.league.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeagueController {

	private final LeagueService leagueService;

	@GetMapping
	public String legueInfoForm(Model model) throws JsonProcessingException {
		List<RankDTO> rankList = leagueService.getrank();
		rankList = leagueService.ranksort(rankList);

		Map<LocalDate, List<NewsDTO>> newsMap = leagueService.getnews();

		// newsMap의 LocalDate를 역순으로 정렬
		Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
		reversedNewsMap.putAll(newsMap);

		// 역순으로 정렬된 LocalDate만 따로 추출하여 리스트로 변환
		List<LocalDate> reversedDates = new ArrayList<>(reversedNewsMap.keySet());

		// 역순으로 정렬된 newsMap을 모델에 추가
		model.addAttribute("ranking", rankList);
		model.addAttribute("newsList", reversedNewsMap);
		model.addAttribute("reversedDates", reversedDates);

		return "fragments/league/league-fragment";
	}



}
