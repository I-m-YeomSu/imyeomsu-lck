package imyeom_lck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class ImyeomsuLckApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImyeomsuLckApplication.class, args);
	}

}
