package com.cg.homeloan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeLoanAppApplication {
	private static final Logger LOG = LoggerFactory.getLogger(HomeLoanAppApplication.class);

	public static void main(String[] args) {
		LOG.info("Start Application");
		SpringApplication.run(HomeLoanAppApplication.class, args);
	}

}
