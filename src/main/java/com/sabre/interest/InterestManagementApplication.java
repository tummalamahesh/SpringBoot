package com.sabre.interest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages= {"com.sabre.*"})
@SpringBootApplication
@EntityScan(basePackages ={"com.sabre.*"})
@ComponentScan(basePackages ={"com.sabre.*"})
public class InterestManagementApplication {

	public static void main(String[] args) {
		System.out.println("we are in main---------------------");
		SpringApplication.run(InterestManagementApplication.class, args);
		System.out.println("After initialization----------------------");
	}

}

