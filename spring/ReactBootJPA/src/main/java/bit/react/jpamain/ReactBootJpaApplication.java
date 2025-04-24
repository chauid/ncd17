package bit.react.jpamain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"bit.react.*","naver.storage"})
@EntityScan("bit.react.data")
@EnableJpaRepositories("bit.react.repository")
public class ReactBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactBootJpaApplication.class, args);
	}

}
