package imyeom_lck.hottime;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import static com.mysema.commons.lang.Assert.assertThat;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApplyRestController {

    private final ApplyService applyService;

    @GetMapping(value = "/apply/{userId}")
    public void apply(@PathVariable("userId") Long userId){

        applyService.apply(userId);

    }

    // 100개제한 걸었는데 100개 넘었다?? 동시성문제
    @GetMapping(value="/apply/many")
    public void testApply2() throws InterruptedException {

        applyService.apply2();

    }

    //100개 넘어있는데도 이번엔 왜 들어감?
    // 레디스 카운터라서 가능
    @GetMapping(value="/apply/useRedis/{userId}")
    public void test3(@PathVariable("userId") Long userId){
        applyService.apply3(userId);
    }

    //레디스로 여러개 접근 - 성공
    @GetMapping(value="/apply/useRedis/many")
    public void test4() throws InterruptedException {
        applyService.apply4();
    }

    @GetMapping(value="apply/useRedis/oneAtOnes")
    public void test5() throws InterruptedException {
        applyService.apply6();
    }

    @GetMapping(value="apply/useRedis/last")
    public void testLast() throws InterruptedException{
        applyService.applyLast();
    }


}


