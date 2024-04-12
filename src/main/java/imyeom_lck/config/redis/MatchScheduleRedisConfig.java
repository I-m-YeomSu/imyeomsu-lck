package imyeom_lck.config.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.annotations.Config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class MatchScheduleRedisConfig extends RedisConfig {

	@Bean
	@Primary
	public RedisConnectionFactory matchScheduleRedisConnectionFactory() {
		return redisConnectionFactory(2);  // Redis DB 선택
	}


	@Bean
	@Qualifier("matchScheduleRedisTemplate")
	public RedisTemplate<?, ?> matchScheduleRedisTemplate(ObjectMapper objectMapper) {
		RedisTemplate<?, ?> template = new RedisTemplate<>();

		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
		template.setConnectionFactory(matchScheduleRedisConnectionFactory());
		return template;
	}

}
