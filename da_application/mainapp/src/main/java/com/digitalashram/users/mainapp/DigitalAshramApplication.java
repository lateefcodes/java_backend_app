package com.digitalashram.users.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.digitalashram")
@EntityScan(basePackages="com.digitalashram")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.digitalashram")
public class DigitalAshramApplication {
	//MainappApplication
	public static void main(String[] args) {
		SpringApplication.run(DigitalAshramApplication.class, args);
	}

}
