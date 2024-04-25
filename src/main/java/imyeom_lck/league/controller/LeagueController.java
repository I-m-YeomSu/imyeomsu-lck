package imyeom_lck.league.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.league.domain.dto.NewsDTO;
import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import imyeom_lck.predict.domain.dto.VotedUserDTO;
import imyeom_lck.predict.domain.entity.VotedUser;
import imyeom_lck.predict.persistence.jpa.VotedUserRepository;
import imyeom_lck.predict.service.inter.PredictService;
import imyeom_lck.predict.service.inter.VotedUserService;
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
	private final MatchScheduleService matchScheduleService;
	private final PredictService predictService;
	private final VotedUserRepository votedUserRepository;
	private final VotedUserService votedUserService;

	@GetMapping
	public String leagueInfoForm(Model model) throws JsonProcessingException {
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

	@GetMapping("/predict")
	public String predictForm(Model model) throws JsonProcessingException{
		//팀랭킹
		List<RankDTO> rankList = leagueService.getrank();
		List<MatchesResponseDTO> allMatchesByRedis = matchScheduleService.getAllMatchesByRedis();
		Comparator<MatchesResponseDTO> comparator = Comparator.comparing(MatchesResponseDTO::getMatchDate);
		Collections.sort(allMatchesByRedis, comparator);
		List<VotedUserDTO> votedUserList = predictService.getVotedUserList(1L);
		Long votedAllUserCount = votedUserService.getAllUserCount();

		rankList = leagueService.ranksort(rankList);
		model.addAttribute("ranking", rankList);
		model.addAttribute("matches", allMatchesByRedis);
		model.addAttribute("votedAllUserCount", votedAllUserCount);
		model.addAttribute("votedUserList", votedUserList);

		return "leagues/predict";
	}






}
