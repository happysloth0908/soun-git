import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController1 {

	@GetMapping("/rest1/test1")
	public String test1() {
		return "Hello REST API;
	}

	@GetMapping("/rest1/test2")
	@ResponseBody
	public String test2() {
		return "Hello REST API;
	}

	@GetMapping("/rest/test3")
	public Map<String, String> test3(@RequestParam String param) {
		Map<String, String> data = new Map<>();
		data.put("id", "ssafy");
		data.put("password", "1234");
		
		return data;
	}

}
