package imyeom_lck.hottime;

import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CouponCountRepository {

    private final RedisTemplate<String, String> hotTimeRedisTemplate;
    private final ObjectMapper objectMapper;

    public CouponCountRepository(@Qualifier("hotTimeRedisTemplate") RedisTemplate<String, String> hotTimeRedisTemplate,
                            ObjectMapper objectMapper) {
        this.hotTimeRedisTemplate = hotTimeRedisTemplate;
        this.objectMapper = objectMapper;
    }

    public Long increment(){
        return hotTimeRedisTemplate.opsForValue().increment("coupon count");
    }

    public Long add(Long userid){
        return hotTimeRedisTemplate.opsForSet().add("applied_user", userid.toString());
    }

}

