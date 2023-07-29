package StageTalan.SpringBootApp.MockAPI;

import StageTalan.SpringBootApp.MockAPI.model.Api;
import StageTalan.SpringBootApp.MockAPI.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MockApiApplication.class, args);
	}

	@Autowired
	private ApiRepository apiRepository;

	@Override
	public void run(String... args) throws Exception {}
}
