package imyeom_lck.hottime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class hotTimeEventController {


	@GetMapping("/hot-time")
	public String hotTimeEventForm(){
		return "event/hot-time";
	}
}
