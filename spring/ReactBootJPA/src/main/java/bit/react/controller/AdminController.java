package bit.react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bit.react.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AdminController {
	private final JwtUtil jwtUtil;
	
	@GetMapping("/admin")
	public String admin(HttpServletRequest request)
	{
		//header 로부터 Authorization 를 얻는다
		String auth=request.getHeader("Authorization");
		//Bearer 를 제거한 순수 토큰을 얻는다
		String token=auth.substring(7);
		//토큰만 있으면 username 정보와 role 정보를 얻을수 있다
		String username=jwtUtil.getUsername(token);
		String role=jwtUtil.getRole(token);
		return "admin ok!!! username:"+username+",role:"+role;
	}

}
