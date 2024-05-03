package imyeom_lck.hottime;

import imyeom_lck.hottime.service.inter.HotTimeService;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class hotTimeEventController {

	private final HotTimeService hotTimeService;

	@GetMapping("/hot-time")
	public String hotTimeEventForm(Model model){

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication instanceof UsernamePasswordAuthenticationToken){

			String loginId = authentication.getPrincipal().toString();
			boolean flag = hotTimeService.checkIfValue(loginId);
			model.addAttribute("isParticipated", flag);

		}


		return "event/hot-time";
	}

	@GetMapping("/click")
	public String hotTimeEventClick(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


		if (authentication instanceof UsernamePasswordAuthenticationToken){
			String loginId = authentication.getPrincipal().toString();
			String flag = hotTimeService.hottimeApply(loginId);
			model.addAttribute("flag", flag);
			return "event/hot-time";

		}

		else{
			model.addAttribute("로그인 사용자가 아닙니다.", "kk" );
			return "/auth/login";
		}

	}

}
