package imyeom_lck.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
* 로그인한 회원과 관련된 뷰 처리 컨트롤러 입니다.
* */
@Controller
@RequestMapping("/auth")
public class AuthController {
	@GetMapping("/my-profile")
	public String profileForm(){
		// 후에 로그인 회원 관련해서 로그인 하지 않은 회원은 로그인 화면으로 이동하게 하고 로그인 회원에겐 회원 정보를 노출시킬 예정입니다.
		return "fragments/auth/my-profile";

	}
}
