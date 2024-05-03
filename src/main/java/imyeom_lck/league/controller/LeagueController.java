package imyeom_lck.league.controller;


import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import imyeom_lck.predict.domain.dto.VotedUserDTO;
import imyeom_lck.predict.service.inter.PredictService;
import imyeom_lck.predict.service.inter.VotedUserService;
import imyeom_lck.rank.service.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/leagues")
@RequiredArgsConstructor
public class LeagueController {
	private final RankService rankService;
	private final MatchScheduleService matchScheduleService;
	private final PredictService predictService;
	private final VotedUserService votedUserService;




	@GetMapping("/predict")
	public String predictForm(Model model) throws JsonProcessingException{
		//팀랭킹
		List<RankDTO> rankList = rankService.getRank();

		List<MatchesResponseDTO> allMatchesByRedis = matchScheduleService.getAllMatchesByRedis();
		Comparator<MatchesResponseDTO> comparator = Comparator.comparing(MatchesResponseDTO::getMatchDate);
		Collections.sort(allMatchesByRedis, comparator);
		List<VotedUserDTO> votedUserList = predictService.getVotedUserList(1L);
		Long votedAllUserCount = votedUserService.getAllUserCount();

		rankList = rankService.rankSort(rankList);
		model.addAttribute("ranking", rankList);
		model.addAttribute("matches", allMatchesByRedis);
		model.addAttribute("votedAllUserCount", votedAllUserCount);
		model.addAttribute("votedUserList", votedUserList);

		return "leagues/predict";
	}




}
