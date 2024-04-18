package imyeom_lck.predict.persistence.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class PredictCountRepository {

    private final RedisTemplate<String, String> predictRedisTemplate;
    private final ObjectMapper objectMapper;

    public PredictCountRepository(@Qualifier("predictRedisTemplate") RedisTemplate<String, String> predictRedisTemplate,
                                  ObjectMapper objectMapper){
        this.predictRedisTemplate = predictRedisTemplate;
        this.objectMapper = objectMapper;
    }

    public Long increment(){
        return predictRedisTemplate.opsForValue().increment("predict_count");
    }

    public Long add(Long userid){
        return predictRedisTemplate.opsForSet().add("voted_user", userid.toString());
    }

}
