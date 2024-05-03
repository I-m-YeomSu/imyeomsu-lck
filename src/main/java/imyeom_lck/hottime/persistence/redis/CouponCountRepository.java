package imyeom_lck.hottime.persistence.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
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


    public boolean isMemberOfSet(Long memberId) {
        SetOperations<String, String> setOperations = hotTimeRedisTemplate.opsForSet();
        String value = memberId.toString();
        log.info("value: {}", value);
        return setOperations.isMember("applied_user", value);
    }

}

