package imyeom_lck.config.redis.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import imyeom_lck.config.redis.RedisConfig;

@Configuration
public class HotTimeRedisConfig extends RedisConfig {

    @Bean
    public RedisConnectionFactory hotTimeRedisConnectionFactory() {
        return redisConnectionFactory(3);  // Redis DB 선택
    }


    @Bean
    @Qualifier("hotTimeRedisTemplate")
    public RedisTemplate<?, ?> hotTimeRedisTemplate(ObjectMapper objectMapper) {
        RedisTemplate<?, ?> template = new RedisTemplate<>();

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer(objectMapper));
        template.setConnectionFactory(hotTimeRedisConnectionFactory());
        return template;
    }
}