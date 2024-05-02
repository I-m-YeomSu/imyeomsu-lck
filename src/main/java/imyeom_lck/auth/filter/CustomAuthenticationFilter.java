package imyeom_lck.auth.filter;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import static org.springframework.security.core.context.SecurityContextHolder.*;


@Slf4j
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
		AuthenticationException {
		log.info("BadCredentialsException : 사용자 입력 값이 허용되지 않습니다. 다시 로그인 해주세요");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		log.info("{}{}", loginId,password);

		if (loginId.isBlank() || loginId.isEmpty() || password.isEmpty()|| password.isBlank()){
			log.info("BadCredentialsException : 사용자 입력 값이 허용되지 않습니다. 다시 로그인 해주세요");
			throw new BadCredentialsException("사용자 입력 값이 허용되지 않습니다. 다시 로그인 해주세요");
		}

		return UsernamePasswordAuthenticationToken.unauthenticated(loginId, password);
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authResult) throws IOException, ServletException {


		log.info("{} {} {}", authResult.getPrincipal().toString(), authResult.getCredentials().toString(), authResult.getName());
		SecurityContextHolder.getContext().setAuthentication(authResult);

		response.sendRedirect("/");

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException failed) throws IOException, ServletException {

		log.info("{}",failed.getMessage());
		response.sendRedirect("/auth/login");
	}
}
