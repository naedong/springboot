package kr.co.e4net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class FinalProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(FinalProject1Application.class, args);
	}

}
