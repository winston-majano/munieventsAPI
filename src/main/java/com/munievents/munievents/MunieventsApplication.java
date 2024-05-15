package com.munievents.munievents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MunieventsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MunieventsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MunieventsApplication.class);
		application.addListeners(new SwaggerConfig());
		//SpringApplication.run(MunieventsApplication.class, args);
		SpringApplication.run(MunieventsApplication.class, args);
	}

}
