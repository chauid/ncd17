package bit.react.jwt;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import bit.react.repository.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter { // OncePerRequestFilter -> 한 번 실행 보장

	private final CustomUserDetailsService customUserDetailsService;
	private final JwtUtil jwtUtil;

	@Override
	/**
	 * JWT 토큰 검증 필터 수행
	 */
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		System.out.println("Authorization:"+authorizationHeader);
		//JWT가 헤더에 있는 경우
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			
			String token = authorizationHeader.substring(7);//7번지부터가 실제 토큰
			System.out.println("분리된 토큰:"+token);
			//JWT 유효성 검증
			if (jwtUtil.validateToken(token)) {
				String username = jwtUtil.getUsername(token);
				System.out.println("검증 username="+username);

				//유저와 토큰 일치 시 userDetails 생성
				UserDetails userDetails = customUserDetailsService.loadUserByUsername(username.toString());

				if (userDetails != null) {
					//UserDetsils, Password, Role -> 접근권한 인증 Token 생성
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
							new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

					//현재 Request의 Security Context에 접근권한 설정
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		}

		filterChain.doFilter(request, response); // 다음 필터로 넘기기
	}
}