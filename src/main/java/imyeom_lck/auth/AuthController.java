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
		return "fragments/auth/my-profile";

	}
}
