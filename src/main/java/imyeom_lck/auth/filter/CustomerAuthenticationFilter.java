package imyeom_lck.auth.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public CustomerAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
		AuthenticationException {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		if (loginId.isBlank() || loginId.isEmpty() || password.isEmpty()|| password.isBlank()){
				throw new BadCredentialsException("사용자 입력 값이 허용되지 않습니다. 다시 로그인 해주세요");
		}

		return UsernamePasswordAuthenticationToken.unauthenticated(loginId, password);
	}


	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authResult) throws IOException, ServletException {


		response.sendRedirect("/");

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException failed) throws IOException, ServletException {


		response.sendRedirect("/auth/login");
	}
}
