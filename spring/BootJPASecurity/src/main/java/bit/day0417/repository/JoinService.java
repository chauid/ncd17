package bit.day0417.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import bit.day0417.data.JoinDTO;
import bit.day0417.data.UserEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinService {
	final UserRepository userRepository;
	final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProcess(JoinDTO dto)
	{
		//db에 이미 동일한 username을 가진 회원이 존재하는지?
		boolean isUser=userRepository.existsByUsername(dto.getUsername());
		if(isUser) {
			System.out.println(dto.getUsername()+" 이미 존재함!!");	
			return;
		}else {
			System.out.println(dto.getUsername()+" DB 저장함!!");
		}
		
		UserEntity data=new UserEntity();
		data.setUsername(dto.getUsername());
		data.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));//암호화되어 저장
		data.setRole(dto.getRole());	
		
		userRepository.save(data);//db저장하는 jpa 에서 제공하는 메서드
	}
}





















