package com.example.cloud.producer;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EntityScan("com.example.cloud.pojo")
public class ProducerApplication{

	public static void main(String[] args) {
		new SpringApplicationBuilder(ProducerApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);
	}

}
