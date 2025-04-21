package bit.day0417.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bit.day0417.data.UserEntity;

public class CustomUserDetail implements UserDetails{

	private UserEntity userEntity;
	
	public CustomUserDetail(UserEntity userEntity) {
		// TODO Auto-generated constructor stub
		this.userEntity=userEntity;
	}
	
	//사용자의 권한에 대해서 리턴해주는 메서드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collection=new ArrayList<>();
		
		collection.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return userEntity.getRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEntity.getUsername();
	}

}
