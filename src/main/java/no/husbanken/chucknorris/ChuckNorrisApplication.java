package no.husbanken.chucknorris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ChuckNorrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChuckNorrisApplication.class, args);
	}

}
