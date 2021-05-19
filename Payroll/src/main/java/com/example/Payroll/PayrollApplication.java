package com.example.Payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PayrollApplication {

	public static void main(String... args) {
		CustomerTemplate customerTemplate = new CustomerTemplate();
		Customer customer = new Customer("Henna", "Mäkinen", "private", 50009077);
		
		SpringApplication.run(PayrollApplication.class, args);
		
		customerTemplate.postCustomer(customer);
		customerTemplate.deleteCustomer(1);
		System.out.println(customerTemplate.getAllCustomers());
	}

}
