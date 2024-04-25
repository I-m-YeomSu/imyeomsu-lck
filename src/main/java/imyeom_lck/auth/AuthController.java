package imyeom_lck.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.service.inter.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/*
* 로그인한 회원과 관련된 뷰 처리 컨트롤러 입니다.
* */
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
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

	@PostMapping("/register")
	public String register(SignUpRequestDTO signUpRequestDTO) {

		// 회원가입 처리 로직
		memberService.signUp(signUpRequestDTO);

		return "redirect:/auth/login";
	}


	@GetMapping("/myPage")
	public String myPage(Model model) {
		MemberDetailsResponseDTO memberDetailsResponseDTO = memberService.getMemberDetails(1L);

		model.addAttribute("memberDetails", memberDetailsResponseDTO);

		return "auth/user/my-page";
	}



}
