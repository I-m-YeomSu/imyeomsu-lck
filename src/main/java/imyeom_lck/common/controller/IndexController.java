package imyeom_lck.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexForm(){
        return "main/index";
    }

    @GetMapping("/event/main")
    public String mainEventForm(){
        return "fragments/event/event-main-fragment";
    }

    @GetMapping("/zz")
    public String zz(){

        return "index";
    }

    @GetMapping("/main")
    public String main(){
        return "fragments/main/main-wrapper";
    }
}
