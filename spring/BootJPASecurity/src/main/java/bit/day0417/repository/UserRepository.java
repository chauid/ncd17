package bit.day0417.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.day0417.data.UserEntity;
import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	public boolean existsByUsername(String username);
	public UserEntity findByUsername(String username);
}
