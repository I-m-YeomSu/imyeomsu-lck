package imyeom_lck.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

import imyeom_lck.config.redis.RedisConfig;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {

    private final EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

	@Configuration
	public static class LoginSessionRedisConfig extends RedisConfig {

		@Bean
		@Primary
		public RedisConnectionFactory loginSessionRedisConnectionFactory() {
			return redisConnectionFactory(0);  // Redis DB 선택
		}


		@Bean
		@Qualifier("loginSessionRedisTemplate")
		public RedisTemplate<?, ?> loginSessionRedisTemplate(ObjectMapper objectMapper) {
			RedisTemplate<?, ?> template = new RedisTemplate<>();

			template.setKeySerializer(new StringRedisSerializer());
			template.setValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
			template.setHashKeySerializer(new StringRedisSerializer());
			template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
			template.setConnectionFactory(loginSessionRedisConnectionFactory());
			return template;
		}
	}
}