package imyeom_lck.common.advisor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
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

		System.out.println("Request Time: " + requestTime);
		System.out.println("Request URL: " + requestUrl);
		System.out.println("Request Method: " + requestMethod);
		System.out.println("Client IP: " + clientIp);
		System.out.println("Session ID: " + sessionId);

		return result;
	}

}