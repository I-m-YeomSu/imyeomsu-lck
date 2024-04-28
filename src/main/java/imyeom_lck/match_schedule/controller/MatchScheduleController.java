package imyeom_lck.match_schedule.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.league.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/match-schedule")
@RequiredArgsConstructor
@Slf4j
public class MatchScheduleController {

	private final MatchScheduleService matchScheduleService;

	private static StringBuilder stringBuilder = new StringBuilder();
	private final LeagueService leagueService;
	/**
	 * 경기 일정 보는 버튼을 누르면 현재 레디스에 담겨 있는 데이터를 이용해서 해당 month에 있는 경기 목록을 모두 보여줍니다.
	 * */
	@GetMapping("/all-matches")
	public String getAllMatchSchedule(Model model) throws JsonProcessingException {

		List<MatchesResponseDTO> allMatchesByRedis = matchScheduleService.getAllMatchesByRedis();
		List<MatchesResponseDTO> dtos = getMatchesResponseDTOS(allMatchesByRedis);
		model.addAttribute("matches", dtos);

		return "schedule/match-schedule";
	}

	@GetMapping("/main")
	public String getMain(Model model) throws JsonProcessingException {

		List<MatchesResponseDTO> allMatchesByRedis = matchScheduleService.getAllMatchesByRedis();
		List<MatchesResponseDTO> dtos = getMatchesResponseDTOS(allMatchesByRedis);
		model.addAttribute("matches", dtos);
		return "schedule/match-schedule";

	}
	@GetMapping("/details")
	public String getMatchScheduleByDetails(@RequestParam(name = "inputDate") String inputDate, Model model) throws JsonProcessingException {
		LocalDate now = LocalDate.now();
		int month = now.getMonth().getValue();
		int year = now.getYear();
		int day = now.getDayOfMonth();

		LocalDate date = getLocalDate(inputDate);

		int chooseMonth = date.getMonth().getValue();
		int chooseYear = date.getYear();
		int chooseDay = date.getDayOfMonth();

		if (chooseMonth == month && chooseYear == year && chooseDay == day){
			log.info("여기 동작해야 됨");
			List<MatchesResponseDTO> allMatchesByRedis = matchScheduleService.getAllMatchesByRedis();
			model.addAttribute("matches", allMatchesByRedis);
		}

		List<MatchesResponseDTO> allMatchesByRdb = matchScheduleService.getAllMatchesByRdb();
		model.addAttribute("matches", allMatchesByRdb);

		return "fragments/main/match-schedule-wrapper";

	}

	@GetMapping("/ranking")
	public String getRanking(Model model) throws JsonProcessingException {

		//팀랭킹
		List<RankDTO> rankList = leagueService.getrank();
		rankList = leagueService.ranksort(rankList);
		model.addAttribute("ranking", rankList);

		return "schedule/ranking";
	}
	@GetMapping("/match-schedule/all-news")
	public String getNews(Model model) throws JsonProcessingException {

		//팀랭킹
		List<RankDTO> rankList = leagueService.getrank();
		rankList = leagueService.ranksort(rankList);
		model.addAttribute("ranking", rankList);

		return "schedule/ranking";
	}

	private static LocalDate getLocalDate(String scheduleDate) {

		DateTimeFormatter formatter;
		String resultDate = null;
		if (scheduleDate.length() == 7) {
			stringBuilder.append("0");
			stringBuilder.append(scheduleDate);
			scheduleDate = stringBuilder.toString();
		}

		formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate date = LocalDate.parse(scheduleDate, formatter);
		return date;
	}

	public static List<MatchesResponseDTO> getMatchesResponseDTOS(List<MatchesResponseDTO> allMatchesByRedis) {
		List<MatchesResponseDTO> dtos = allMatchesByRedis.stream()
			.sorted(Comparator.comparing(MatchesResponseDTO::getMatchDate)
				.thenComparing(Comparator.comparing(MatchesResponseDTO::getMatchTime).reversed()))
			.collect(Collectors.toList());
		return dtos;
	}

}
