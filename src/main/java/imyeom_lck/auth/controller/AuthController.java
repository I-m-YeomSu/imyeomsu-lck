package imyeom_lck.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;

import imyeom_lck.member.domain.dto.MemberDetailsResponseDTO;
import imyeom_lck.member.domain.dto.SignUpRequestDTO;
import imyeom_lck.member.service.inter.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/*
* 로그인한 회원과 관련된 뷰 처리 컨트롤러 입니다.
* */
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {

	private final MemberService memberService;


	@GetMapping("/my-page/{memberId}")
	public String profileForm(@PathVariable("memberId") Long memberId, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails details = (UserDetails)authentication.getDetails();
		String username = details.getUsername();
		MemberDetailsResponseDTO byLoginId = memberService.findByLoginId(username);

		//MemberDetailsResponseDTO memberDetailsResponseDTO = memberService.getMemberDetails(username);

		model.addAttribute("memberDetails", byLoginId);

		return "fragments/auth/my-page";

	}

	@GetMapping("/login")
	public String loginForm() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		log.info("{} {} {}",authentication.getCredentials(), authentication.isAuthenticated(), authentication.getName());

		if (authentication.getPrincipal().toString().equals("anonymousUser")){
			return "auth/user/login";
		}


		return "redirect:/";

	}

	@PostMapping("/register")
	public String register(SignUpRequestDTO signUpRequestDTO) {

		// 회원가입 처리 로직
		memberService.signUp(signUpRequestDTO);

		return "redirect:/auth/login";
	}


	@GetMapping("/my-page")
	public String myPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loginId = authentication.getName();
		log.info("{}", loginId);
		MemberDetailsResponseDTO byLoginId = memberService.findByLoginId(loginId);

		model.addAttribute("memberDetails", byLoginId);

		return "auth/user/my-page";
	}


	@GetMapping("/modify/password")
	public String modifyPasswordForm(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String loginId = authentication.getName();
		log.info("ppppppppppppppppppppaaaaaaaaaaaaaaaaaaaa{}", loginId);

		MemberDetailsResponseDTO byLoginId = memberService.findByLoginId(loginId);

		model.addAttribute("memberDetails", byLoginId);
		return "auth/user/modify-password";
	}

	@PostMapping("/modify/password/{loginId}")
	public String modifyPassword(@PathVariable(name = "loginId") String loginId, String newPassword){

		memberService.updatePassword(loginId,newPassword);
		return "redirect:/auth/my-page";
	}


	@GetMapping("/signup")
	public String signup() {

		return "auth/user/signup";
	}


	@GetMapping("/logout")
	public String logout(Model model){


		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("{} {} {}",authentication.getCredentials(), authentication.isAuthenticated(), authentication.getName());

		model.addAttribute("message", "회원 로그인이 정상적으로 이뤄졌습니다.");
		return "redirect:/auth/login";
	}

	@GetMapping("/admin/login")
	public String adminLogin(){

		return "auth/admin/login";
	}

	@GetMapping("/admin/signup")
	public String adminSignup(){
		return "auth/admin/signup";
	}

	@PreAuthorize("isAuthenticated() and (( #user.name == principal.name ) or hasRole('ROLE_ADMIN'))")
	@GetMapping("/admin/main")
	public String adminMain(){

		return "auth/admin/main";
	}
}
