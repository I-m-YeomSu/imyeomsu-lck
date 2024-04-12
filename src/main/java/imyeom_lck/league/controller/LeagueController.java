package imyeom_lck.league.controller;


import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeagueController {

	private final LeagueService leagueService;

	@GetMapping()
	public String legueInfoForm(Model model){
		List<RankDTO> rankList = leagueService.redistest();
		rankList = leagueService.ranksort(rankList);
		model.addAttribute("ranking", rankList);
		return "fragments/league/league-fragment";
	}

}
