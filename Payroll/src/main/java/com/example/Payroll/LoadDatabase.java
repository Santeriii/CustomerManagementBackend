package com.example.Payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(CustomerRepository repository) {
		
		return args -> {
			log.info("Preloading " + repository.save(new Customer("Mauri", "Äkäslompolo", "private", 62627333)));
			log.info("Preloading " + repository.save(new Customer("Jenna", "Jääskeläinen", "company", 74551862)));
			log.info("Preloading " + repository.save(new Customer("Mika", "Verhosuo", "company", 99120375)));
		};
	}
}
