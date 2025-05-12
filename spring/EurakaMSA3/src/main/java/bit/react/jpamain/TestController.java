package bit.react.jpamain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Value("${mysql.username}")
	private String username;
	
	@Value("${mysql.password}")
	private String password;
	
	@Value("${mysql.url}")
	private String  url;
	
	@GetMapping("/")
	public Map<String,String> home()
	{
		Map<String,String> map=new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		map.put("url", url);
		return map;
	}
}





