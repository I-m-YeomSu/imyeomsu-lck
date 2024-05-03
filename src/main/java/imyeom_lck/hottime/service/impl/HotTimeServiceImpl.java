package imyeom_lck.hottime.service.impl;

import imyeom_lck.hottime.Coupon;
import imyeom_lck.hottime.CouponCountRepository;
import imyeom_lck.hottime.CouponRepository;
import imyeom_lck.hottime.service.inter.HotTimeService;
import imyeom_lck.member.persistence.jpa.JpaMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotTimeServiceImpl implements HotTimeService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final JpaMemberRepository memberRepository;

    public String hottimeApply(String loginId){
        Long memberId = memberRepository.findByLoginId(loginId).get().getMemberId();
        Long appliedUser = couponCountRepository.add(memberId);

        if(appliedUser == 1){
            Long count = couponCountRepository.increment();

            if(count > 100){
                log.info("100개이상일때:{}",count);
                return "수량초과";
            }

            couponRepository.save(new Coupon(memberId));
            log.info("100개 미만일때 저장하고:{}",count);
            return "성공";
        }
        log.info("유저존재하면:{}",appliedUser);
        return "이미참여";
    }

    public String checkIfValue(String loginId) {
        Long memberId = memberRepository.findByLoginId(loginId).get().getMemberId();
        boolean check = couponCountRepository.isMemberOfSet(memberId);
        if(check){
            return "쿠폰 발급 완료!";
        }
        else {
            return "";
        }
    }

}
