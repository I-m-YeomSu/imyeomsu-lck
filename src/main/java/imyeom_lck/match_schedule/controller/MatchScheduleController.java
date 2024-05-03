package imyeom_lck.match_schedule.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;

import imyeom_lck.match_schedule.domain.dto.MatchesViewResponseDTO;
import imyeom_lck.rank.domain.dto.RankDTO;
import imyeom_lck.league.service.inter.LeagueService;
import imyeom_lck.match_schedule.domain.dto.MatchesResponseDTO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	 * 한달 기준을 기점으로 진행합니다.
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

	@GetMapping("/details")//http://localhost:8080/match-schedule/details?year=2024&month=4&day=10
	public String getMatchScheduleByDetails(@RequestParam("year") String year, @RequestParam("month") String month, @RequestParam("day")String day, Model model) throws JsonProcessingException {
		log.info("dldldldldldl이이이ㅣ거 오나? {} {} {} ", year, month, day);
		LocalDate now = LocalDate.now();
		int nowMonth = now.getMonth().getValue();
		int nowYear = now.getYear();
		int nowDay = now.getDayOfMonth();
		log.info("dldldldldldl이이이ㅣ거 오나22? {} {} {} ", nowYear, nowMonth, nowDay);

		
		//올해 이번달을 선택하면 레디스 정보를 보여줘도 됨
		if (nowMonth== Integer.parseInt(month) && nowYear == Integer.parseInt(year)){

			List<MatchesViewResponseDTO> matchesResponseDTO = matchScheduleService.getAllMatchSchedule();
			List<MatchesViewResponseDTO> resultDTO = new ArrayList<>();
			for (MatchesViewResponseDTO matchesViewResponseDTO : matchesResponseDTO) {
				String matchDate = matchesViewResponseDTO.getMatchDate();
				System.out.println(matchDate);

				String substring = matchDate.substring(7, matchDate.length());
				System.out.println(substring);
				if (Integer.parseInt(substring)== Integer.parseInt(day)){
					resultDTO.add(matchesViewResponseDTO);
				}
			}

			if (resultDTO.isEmpty()) {
				resultDTO.add(MatchesViewResponseDTO.builder()
						.matchDate("해당 날짜에 해당 하는 경기가 없습니다.")
						.matchTime("0000")
						.matchState("경기 없음")
						.matchTitle("경기 없음")
						.homeTeamScore("0")
						.awayTeamScore("0")
						.homeTeamLogo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRozIMGwRtwhEldcwjYieSffaiTlMF0fnRPsQ33YoMANQ&s")
						.awayTeamLogo("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRozIMGwRtwhEldcwjYieSffaiTlMF0fnRPsQ33YoMANQ&s")
						.homeTeamName(" ")
						.awayTeamName(" ")
					.build());
			}
			model.addAttribute("matches", resultDTO);
			return "fragments/main/match-schedule-wrapper";
		}



		List<MatchesResponseDTO> allMatchesByRdb = matchScheduleService.getAllMatchesByRdb();
		model.addAttribute("matches", allMatchesByRdb);

		return "fragments/main/match-schedule-wrapper";

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
