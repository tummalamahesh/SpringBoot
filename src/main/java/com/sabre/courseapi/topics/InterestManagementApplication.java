package com.sabre.courseapi.topics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses=com.sabre.courseapi.topics.TopicRepository.class)
@SpringBootApplication
@EntityScan("com.sabre")
public class InterestManagementApplication {

	public static void main(String[] args) {
		System.out.println("we are in main---------------------");
		SpringApplication.run(InterestManagementApplication.class, args);
		System.out.println("After initialization----------------------");
	}

}

