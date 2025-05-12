package bit.react.jpamain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("bit.react.*")
@EnableDiscoveryClient
public class EurakaMsa3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurakaMsa3Application.class, args);
	}

}
