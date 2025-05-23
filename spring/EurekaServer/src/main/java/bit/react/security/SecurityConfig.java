package bit.react.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http.csrf(auth->auth.disable());
		
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());//로그인시 접근가능
		
		http.httpBasic(Customizer.withDefaults());//기본 로그인폼 사용
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails user1=User.builder()
				.username("admin")
				.password(bCryptPasswordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1);
	}
}

















