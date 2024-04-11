package imyeom_lck.common.advisor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.logging.Logger;

@Aspect
@Component
@Slf4j
public class RequestAdvisor {

	@Around("execution(* imyeom_lck..*Controller.*(..))")
	public Object requestLogging(ProceedingJoinPoint pjp) throws Throwable {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		// 요청 시간
		long requestTime = System.currentTimeMillis();
		// 요청 URL
		String requestUrl = request.getRequestURL().toString();
		// 요청 메소드
		String requestMethod = request.getMethod();
		// 사용자 IP 주소
		String clientIp = request.getRemoteAddr();
		// 사용자 세션 ID
		HttpSession session = request.getSession();
		String sessionId = session.getId();

		Object result = pjp.proceed();

		log.info("Request Time: " + requestTime);
		log.info("Request URL: " + requestUrl);
		log.info("Request Method: " + requestMethod);
		log.info("Client IP: " + clientIp);
		log.info("Session ID: " + sessionId);

		return result;
	}

}