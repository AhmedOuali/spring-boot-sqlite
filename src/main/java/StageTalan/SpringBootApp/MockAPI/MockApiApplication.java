package StageTalan.SpringBootApp.MockAPI;

import StageTalan.SpringBootApp.MockAPI.controller.ApiController;
import StageTalan.SpringBootApp.MockAPI.model.Api;
import StageTalan.SpringBootApp.MockAPI.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MockApiApplication implements CommandLineRunner, WebMvcConfigurer {

	@Autowired
	private RequestInterceptor requestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
	}

	public static void main(String[] args) {
		SpringApplication.run(MockApiApplication.class, args);
	}


	@Autowired
	private ApiRepository apiRepository;

	@Override
	public void run(String... args) throws Exception {}
}
