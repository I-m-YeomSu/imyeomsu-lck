package imyeom_lck.match_schedule.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
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
	private StringBuilder stringBuilder = new StringBuilder();

	/**
	 * 경기 일정 보는 버튼을 누르면 현재 레디스에 담겨 있는 데이터를 이용해서 해당 month에 있는 경기 목록을 모두 보여줍니다.
	 * */
	@GetMapping("/all-matches")
	public String getAllMatchSchedule(Model model) throws JsonProcessingException {
		log.info("여기를 오고");
		List<MatchesResponseDTO> allMatchesByRedis = matchScheduleService.getAllMatchesByRedis();
		log.info("여기도 오나?");
		model.addAttribute("matches", allMatchesByRedis);

		return "schedule/match-schedule";
	}


	@GetMapping("/dd")
	public String getMatchSchedule(@RequestParam(name = "scheduleDate") String scheduleDate,
								   Model model) throws JsonProcessingException {

		LocalDate now = LocalDate.now();
		int month = now.getMonth().getValue();
		int year = now.getYear();
		int day = now.getDayOfMonth();


		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				.appendValue(ChronoField.DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE) // 일 (1~2자리)
				.appendValue(ChronoField.MONTH_OF_YEAR, 1, 2, SignStyle.NOT_NEGATIVE) // 월 (1~2자리)
				.appendValue(ChronoField.YEAR, 4, 10, SignStyle.NOT_NEGATIVE) // 연도 (4자리)
				.toFormatter();
		LocalDate date = LocalDate.parse(scheduleDate, formatter);

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

		return "schedule/match-schedule";

	}

	@GetMapping("/test")
	public String getMatchScheduleByDetails(String chooseMonth, String chooseDay, String chooseYear, Model model) throws JsonProcessingException {
		LocalDate now = LocalDate.now();
		int month = now.getMonth().getValue();
		int year = now.getYear();
		int day = now.getDayOfMonth();


		if (Integer.parseInt(chooseMonth) == month && Integer.parseInt(chooseYear) == year && Integer.parseInt(chooseDay) == day){

			List<MatchesResponseDTO> allMatchesByRedis = matchScheduleService.getAllMatchesByRedis();
			model.addAttribute("matches", allMatchesByRedis);
		}

		List<MatchesResponseDTO> allMatchesByRdb = matchScheduleService.getAllMatchesByRdb();
		model.addAttribute("matches", allMatchesByRdb);

		return "fragments/main/match-schedule-wrapper";

	}




}
