package imyeom_lck.hottime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.mysema.commons.lang.Assert.assertThat;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public void apply(Long userId){

        long count = couponRepository.count();

        log.info("couponcount:{}",count);

        if(count>100){
            return;
        }

        couponRepository.save(new Coupon(userId));

    }

    public void apply2() throws InterruptedException {
        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i = 0 ; i < threadCount ; i++){
            long userId = i;
            executorService.submit(()->{
                try{
                    apply(userId);
                }
                finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        long count = couponRepository.count();
        log.info("count:{}", count);
    }

    public void apply3(Long userId){
        Long count = couponCountRepository.increment();

        if(count > 100){
            return;
        }

        log.info("쿠폰개수:{}", count);
        couponRepository.save(new Coupon(userId));
    }

    public void apply4() throws InterruptedException {
        int threadCount = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i = 0 ; i < threadCount ; i++){
            long userId = i;
            executorService.submit(()->{
                try{
                    apply3(userId);
                }
                finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        long count = couponRepository.count();
        log.info("count:{}-----------------------", count);
    }

    public void apply5(Long userId){
        Long appliedUser = couponCountRepository.add(userId);
        log.info("input!!!!!!!!!!!!!:{}",appliedUser);
        if(appliedUser != 1){
            log.info("return!!!!!!:{}", appliedUser);
            return;
        }
    }

    public void apply6() throws InterruptedException{
        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i = 200 ; i < threadCount+200 ; i++){
            long userId = i;
            executorService.submit(()->{
                try{
                    apply5(userId);
                }
                finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        Thread.sleep(1000);
    }

    public void applyLast() throws InterruptedException {
        int threadCount = 10000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i = 0 ; i < threadCount ; i++){
            long userId = i;
            executorService.submit(()->{
                try{
                    apply3(userId);
                    apply5(userId);
                }
                finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        long count = couponRepository.count();
        log.info("count:{}-----------------------", count);
    }


}

