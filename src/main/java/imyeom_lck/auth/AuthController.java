package imyeom_lck.auth;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.service.inter.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/*
* 로그인한 회원과 관련된 뷰 처리 컨트롤러 입니다.
* */
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

	private final MemberService memberService;

	@GetMapping("/{memberId}")
	public String profileForm(@PathVariable("memberId") Long memberId, Model model) {

		MemberDetailsResponseDTO memberDetailsResponseDTO = memberService.getMemberDetails(memberId);

		model.addAttribute("memberDetails", memberDetailsResponseDTO);

		return "fragments/auth/my-profile";

	}

	@GetMapping("/login")
	public String loginForm() {
		return "auth/user/login";

	}
}
