package bit.react.jpamain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public String home()
	{
		return "MSA 2번째 프러ㅗ젝트 #2";
	}
}
