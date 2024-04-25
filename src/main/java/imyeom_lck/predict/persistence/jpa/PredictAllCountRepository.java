package imyeom_lck.predict.persistence.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class PredictAllCountRepository {

    private final RedisTemplate<String, String> predictAllRedisTemplate;
    private final ObjectMapper objectMapper;

    public PredictAllCountRepository(@Qualifier("predictAllRedisTemplate") RedisTemplate<String, String> predictAllRedisTemplate,
                                  ObjectMapper objectMapper){
        this.predictAllRedisTemplate = predictAllRedisTemplate;
        this.objectMapper = objectMapper;
    }

    public Long increment(){
        return predictAllRedisTemplate.opsForValue().increment("predict_all_count");
    }

    public Long add(Long userid){
        return predictAllRedisTemplate.opsForSet().add("voted_all_user", userid.toString());
    }

}
