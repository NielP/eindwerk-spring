package eu.elision.demospringright;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("eu.elision.demospringright.repository")
public class DemoSpringRightApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringRightApplication.class, args);
	}

}
