package com.example.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;


@EnableAutoConfiguration(exclude = {
SecurityAutoConfiguration.class,
org.activiti.spring.boot.SecurityAutoConfiguration.class,
})
@SpringBootApplication
@EntityScan("com.example.cloud.pojo")
public class Application{
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
