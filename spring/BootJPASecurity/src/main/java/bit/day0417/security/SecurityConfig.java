package bit.day0417.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /*
     * 시큐리티 암호화
        스프링 시큐리티는 사용자 인증(로그인)시 비밀번호에 대해 단방향 해시 암호화를 진행하여 
        저장되어 있는 비밀번호와 대조한다.

        따라서 회원가입시 비밀번호 항목에 대해서 암호화를 진행해야 한다.

        스프링 시큐리티는 암호화를 위해 BCrypt Password Encoder를 제공하고 권장한다. 
        따라서 해당 클래스를 return하는 메소드를 만들어 @Bean으로 등록하여 사용하면 된다.
     */
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean	
	SecurityFilterChain filterChain(HttpSecurity http,
			CustomLoginSuccessHandler loginSuccessHandler) throws Exception
	{
		http
		.authorizeHttpRequests(auth->auth  //스프링부트 3점대부터는 무조건 람다식으로 코딩해야만 한다
				.requestMatchers("/","/login","/join","/joinproc","/loginproc").permitAll() //모든 접근 허용(Role 상관없이)
				.requestMatchers("/admin").hasRole("ADMIN")//ADMIN 롤만 접근 가능(db에는 ROLE_ADMIN 으로 저장)
				.requestMatchers("/mypage/**").hasAnyRole("ADMIN","USER")//ADMIN,USER 롤만 접근 가능
				.anyRequest().authenticated() //그 이외에는 로그인을 해야만 접근가능한 페이지들
			);
		
	     http
	     .formLogin((auth)->auth.loginPage("/login")
	    		.loginProcessingUrl("/loginproc") //loginproc 매핑이 들어오면 로그인 처리 페이지로 자동 이동
	    		//.defaultSuccessUrl("/mypage")//로그인 성공후 이동할 페이지
	    		.successHandler(loginSuccessHandler) //커스텀한 로그인 메서드 호출
	    		.permitAll()
	    		)
	     .logout(logout->logout
	    		 .logoutUrl("/logout") //로그아웃 url 설정
	     		 .logoutSuccessUrl("/login")); //로그아웃 성공후 이동할 페이지
	     //접근 불가 페이지 접근시 오류페이지 띄우기
	     http
	       .exceptionHandling(exception->exception
	    		   .accessDeniedPage("/access-denied"));
	     
	 	//사이트 위조요청 설정이 자동으로 설정되어있어서
		//원래는 토큰값을 보내야 하는데 개발환경에서 일단은 사용안함으로 설정
		//csrf 공격에 대한 옵션 꺼두기
		/*
		 * CSRF란, Cross Site Request Forgery 의 약자로, 한글 뜻으로는 사이트간 요청 위조를 뜻합니다.
		 * CSRF는 웹 보안 취약점의 일종이며, 사용자가 자신의 의지와는 무관하게 공격자가 
		 * 의도한 행위(데이터 수정, 삭제, 등록 등) 을 특정 웹사이트에 요청하게 하는 공격입니다.
		 * 예를 들어, 피해자의 전자 메일 주소를 변경하거나 암호를 변경하거나 자금이체를 하는 등의 
		 * 동작을 수행하게 할 수 있습니다.
		 * 특성에 따라, 공격자는 사용자의 계정에 대한 완전한 제어권을 얻을 수 있을 수도 있습니다.
		 */
	     http
	      .csrf(auth->auth.disable());//csrf 비활성화
		return http.build();
	}
}
