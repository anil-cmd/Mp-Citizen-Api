package in.anil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class UserAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(UserAppApplication.class, args);
	}

}
