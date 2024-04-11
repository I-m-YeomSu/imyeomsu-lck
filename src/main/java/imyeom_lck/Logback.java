package imyeom_lck;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Logback {

    // aop 적용 안되는거 테스토용코드
    @GetMapping(value = "/logtest")
    public static void test(){
        log.info("loglog");
    }

}
