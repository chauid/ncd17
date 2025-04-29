package bit.react.repository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bit.react.data.UserEntity;
import bit.react.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	private final JwtUtil jwtUtil;
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	public String login(String username,String password)
	{
		UserEntity user=userRepository.findByUsername(username);
		if(user==null) {
			System.out.println("아이디가 존재하지 않습니다");
			return null;
		}
		
		if(!encoder.matches(password, user.getPassword())) {
			System.out.println("비밀번호가 일치하지 않아요!");
			return null;
		}
		
		String accessToken=jwtUtil.createAccessToken(user);
		return accessToken;
			
	}
	
}
