package imyeom_lck.auth.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import imyeom_lck.auth.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private final CustomUserDetailsService customUserDetailsService;
	private final BCryptPasswordEncoder encoder;

	//Custom한 UserDetails에 있는 필드로 매칭합니다. 후에 실제 loadUserByUsername에서 받아온 데이터 값과 입력 받은 값을 비교
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String loginId = authentication.getName();
		String pwd = String.valueOf(authentication.getCredentials());


		UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginId); //실제 DB에서 받아온 값을 Custom 한 객체

		if (userDetails.getUsername().equals(loginId) && encoder.matches(pwd, userDetails.getPassword())) {


		}

		return UsernamePasswordAuthenticationToken.authenticated(loginId, "", userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
