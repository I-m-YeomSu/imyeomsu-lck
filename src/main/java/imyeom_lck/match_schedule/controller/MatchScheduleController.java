package imyeom_lck.match_schedule.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import imyeom_lck.match_schedule.domain.entity.MatchSchedule;
import imyeom_lck.match_schedule.service.inter.MatchScheduleService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/match-schedule")
public class MatchScheduleController {


	@GetMapping("/all-matches")
	public String getAllMatchSchedule(){



		return "schedule/match-schedule";
	}


}
