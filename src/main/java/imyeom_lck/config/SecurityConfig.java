package imyeom_lck.config;


import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import imyeom_lck.auth.filter.CustomAuthenticationFilter;
import imyeom_lck.auth.provider.CustomAuthenticationProvider;
import imyeom_lck.auth.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

import java.util.logging.Filter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	private final CustomUserDetailsService customUserDetailsService;

	private final CorsConfig corsConfig;


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
			.addFilter(corsConfig.corsFilter())
			.addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		http.csrf(csrfConfigurer -> csrfConfigurer.disable());

		http.headers(headerConfig -> headerConfig.frameOptions(
			frameOptionsConfig -> frameOptionsConfig.disable()));


		http.formLogin(httpSecurityFormLoginConfigurer -> {
			httpSecurityFormLoginConfigurer.loginPage("/auth/login").permitAll();
			httpSecurityFormLoginConfigurer.passwordParameter("password");
			httpSecurityFormLoginConfigurer.usernameParameter("loginId");
		});

		http.sessionManagement(sessionManagementConfigurer -> {
			sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		});


		http.rememberMe(rememberMecConfig -> {
			rememberMecConfig.rememberMeParameter("remember");
			rememberMecConfig.alwaysRemember(false);//체크박스 사용 없이도 늘 활성화 시키기
			rememberMecConfig.userDetailsService(customUserDetailsService);
		});

		http.logout(logout -> {logout.logoutUrl("/auth/logout");
			logout.logoutSuccessUrl("/");
			logout.invalidateHttpSession(true); // 로그아웃 후 JSESSIONID 이름의 쿠키값 삭제
			logout.deleteCookies("JSESSIONID", "remember-me");
		});


		//사용자 권한이 필요한 곳엔 로그인 작업을 할수 있게 합니다.
		http.authorizeHttpRequests(auth -> {

			auth.requestMatchers(antMatcher("/auth/**")).permitAll();
			auth.requestMatchers(antMatcher("/apply/**")).authenticated();
			auth.requestMatchers(antMatcher("comments/**")).authenticated();
			auth.requestMatchers(antMatcher("/api/predict/vote")).authenticated();
			auth.requestMatchers(antMatcher("/admin/**")).hasAuthority("ROLE_ADMIN"); // 관리자만 접근 가능하게 합니다.
			auth.requestMatchers(antMatcher("/members/**")).hasAuthority("ROLE_USER");
			auth.anyRequest().permitAll();
		});


		return http.build();

	}


	@Bean
	public CustomAuthenticationFilter authenticationFilter() throws Exception {
		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(null));

		// 해당 부분은 Custom한 AuthenticationManager를 사용해도 되지만 굳이 사용하지 않아도 되기 떄문에 설정을 이렇게 진행 해줌
		customAuthenticationFilter.setAuthenticationManager(new ProviderManager(customAuthenticationProvider()));

		return customAuthenticationFilter;
	}

	@Bean
	public CustomAuthenticationProvider customAuthenticationProvider() {
		return new CustomAuthenticationProvider(customUserDetailsService, encoder());
	}


	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}


	/**
	 * 정적 리소스와 관련된 정보를 security 대상에서 제외시킬 때 사용합니다.
	 * */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer(){
		return (web) -> {
			web
				.ignoring()
				.requestMatchers(
					PathRequest.toStaticResources().atCommonLocations()
				);
		};
	}



	//사용자 계정 생성 시 해당 엔코더를 사용해 암호화한 데이터를 저장하고 로그인 시 해당 엔코더를 사용해 비밀번호를 확인합니다.
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
}
