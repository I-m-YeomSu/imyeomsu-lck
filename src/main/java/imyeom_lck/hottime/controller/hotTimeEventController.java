package imyeom_lck.hottime.controller;

import imyeom_lck.hottime.service.inter.HotTimeService;
import imyeom_lck.member.domain.entity.Member;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/event")
public class hotTimeEventController {

	private final HotTimeService hotTimeService;

	@GetMapping("/hot-time")
	public String hotTimeEventForm(Model model){
		model.addAttribute("localDate", LocalDate.now());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication instanceof UsernamePasswordAuthenticationToken){

			String loginId = authentication.getPrincipal().toString();
			String flag = hotTimeService.checkIfValue(loginId);
			model.addAttribute("isParticipated", flag);

			model.addAttribute("user", loginId);
		}

		return "event/hot-time";
	}

	@GetMapping("/click")
	public void hotTimeEventClick(Model model, HttpServletResponse response) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//혹시 수야 이거 부분 이미 투표한 회원이거나 그런것도 나눌 수 있냐 ??
		if (authentication instanceof UsernamePasswordAuthenticationToken) {
			String loginId = authentication.getPrincipal().toString();
			String flag = hotTimeService.hottimeApply(loginId);
			model.addAttribute("flag", flag);

			// 인증된 사용자일 경우 리다이렉트
			response.sendRedirect("/event/hot-time");
		} else {
			// 인증되지 않은 사용자일 경우 HTTP 상태 코드 401 반환
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"error\": \"인증되지 않은 회원입니다. 로그인 해주세요.\"}");
		}
	}


}
