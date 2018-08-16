package com.yanmaikeji.ygjydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class YgjydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YgjydemoApplication.class, args);
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(YgjydemoApplication.class);
//	    builder.headless(true).web(false).run(args);
	}
}
