package imyeom_lck.hottime.persistence.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import imyeom_lck.hottime.Coupon;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}

