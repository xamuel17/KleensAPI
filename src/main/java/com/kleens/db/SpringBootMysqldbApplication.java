package com.kleens.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories(basePackages = "com.kleens.db.Repo")
@ComponentScan({"com.kleens.db","com.kleens.webApp.Controller"})
@SpringBootApplication
public class SpringBootMysqldbApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootMysqldbApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqldbApplication.class, args);
	}
}
//package com.kleens.db;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@EnableJpaRepositories(basePackages = "com.kleens.db.Repo")
//@SpringBootApplication
//public class SpringBootMysqldbApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootMysqldbApplication.class, args);
//	}
//}

