package com.apis.employees.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.apis.employees.controller.EmployeeController;


@SpringBootApplication
@ComponentScan({"com.apis.employees.controller","com.apis.employees.service"})
@EnableJpaRepositories({"com.apis.employees.repository"})
@EntityScan({"com.apis.employees.model"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
