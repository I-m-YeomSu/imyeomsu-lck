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

		// Localdate 역순으로 newsList 저장
		Map<LocalDate, List<NewsDTO>> reversedNewsMap = new TreeMap<>(Comparator.reverseOrder());
		reversedNewsMap.putAll(newsMap);

		// Localdate만 역순으로 저장
		List<LocalDate> reversedDates = new ArrayList<>(reversedNewsMap.keySet());

		model.addAttribute("ranking", rankList);
		model.addAttribute("newsList", reversedNewsMap);
		model.addAttribute("reversedDates", reversedDates);

		return "fragments/league/league-fragment";
	}



}
