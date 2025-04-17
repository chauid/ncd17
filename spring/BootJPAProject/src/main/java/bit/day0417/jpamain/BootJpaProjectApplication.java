package bit.day0417.jpamain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("bit.day0417.*")
@EntityScan("bit.day0417.data")  //entity 클래스가 들어있는 패키지 설정
@EnableJpaRepositories("bit.day0417.repository")
public class BootJpaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJpaProjectApplication.class, args);
	}

}
