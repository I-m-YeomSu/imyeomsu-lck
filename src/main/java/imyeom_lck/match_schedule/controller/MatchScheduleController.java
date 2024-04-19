package imyeom_lck.match_schedule.controller;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/match-schedule")
@RequiredArgsConstructor
public class MatchScheduleController {

	private final MatchScheduleService matchScheduleService;


	@GetMapping("/all-matches")
	public String getAllMatchSchedule(){

		// 현재 월에 해당하는 경기 스케줄은 redis에서 받아 옵니다.
		LocalDate now = LocalDate.now();
		Month month = now.getMonth();


		// 지난 경기등은 RDB에서 받아 옵니다.



		return "schedule/match-schedule";
	}


}
