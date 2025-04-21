package bit.day0417.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import bit.day0417.data.JoinDTO;
import bit.day0417.repository.JoinService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SecurityTestController {
	
	final JoinService joinService;
	
	@GetMapping("/")
	public String main()
	{
		return "main";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	
	@GetMapping("/mypage")
	public String mypage(Model model)
	{
		//세션 현재 사용자 아이디
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		//세션 사용자 role
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		System.out.println(authentication);
		
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		Iterator<? extends GrantedAuthority> iter=authorities.iterator();
		GrantedAuthority auth=iter.next();
		String role=auth.getAuthority();
		
		model.addAttribute("username", username);
		model.addAttribute("role", role);
		
		return "mypage";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/join")
	public String join()
	{
		return "join";
	}
	//회원가입
	@PostMapping("/joinproc")
	public String joinProc(@ModelAttribute JoinDTO dto)
	{
		joinService.joinProcess(dto);
		return "redirect:./login";//회원가입후 로그인 페이지로 이동
	}
	
	@GetMapping("/access-denied")
	public String accessDenied()
	{
		return "access-denied";
	}

}









