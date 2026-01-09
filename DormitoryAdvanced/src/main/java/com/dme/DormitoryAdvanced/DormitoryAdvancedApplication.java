package com.dme.DormitoryAdvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.dme.DormitoryAdvanced.entity")
@EnableJpaRepositories(basePackages = "com.dme.DormitoryAdvanced.repository")
public class DormitoryAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(DormitoryAdvancedApplication.class, args);
	}

}
