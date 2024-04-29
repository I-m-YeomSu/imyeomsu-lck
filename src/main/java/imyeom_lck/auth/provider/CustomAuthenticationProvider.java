package imyeom_lck.auth.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import imyeom_lck.auth.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private final CustomUserDetailsService customUserDetailsService;
	private final BCryptPasswordEncoder encoder;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String loginId = authentication.getName();

		// log.info("authentication provider: {}", loginId);
		//
		// CustomUserDetailsService userDetails = customUserDetailsService.loadUserByUsername(loginId);
		//
		// String pwd = (String) authentication.getCredentials();
		//
		// if (!userDetails.getUsername().equals(loginId) || !encoder.matches(pwd, userDetails.getPassword())){
		// 	throw new BadCredentialsException("해당 회원의 매칭 정보가 올바르지 않습니다. 다시 확인해주세요");
		//
		// }

		// return UsernamePasswordAuthenticationToken.authenticated(loginId, "", userDetails.getAuthorities());
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
