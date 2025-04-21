package bit.day0417.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.annotations.Comment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();

		//세션 현재 사용자 아이디
		String username=authentication.getName();
		//세션 사용자 role
	
		Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
		Iterator<? extends GrantedAuthority> iter=authorities.iterator();
		GrantedAuthority auth=iter.next();
		String role=auth.getAuthority();
		
		session.setAttribute("username", username);
		session.setAttribute("role", role);
		
		response.sendRedirect("/mypage");
		
	}

}














