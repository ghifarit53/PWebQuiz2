package com.pweb.reddits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ReddItsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReddItsApplication.class, args);
	}

}
