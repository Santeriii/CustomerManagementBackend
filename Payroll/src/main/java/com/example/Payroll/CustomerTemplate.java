package com.example.Payroll;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class CustomerTemplate {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder
				.setConnectTimeout(Duration.ofSeconds(5))
				.setReadTimeout(Duration.ofSeconds(5))
				.build();
	}
	
	RestTemplateBuilder builder = new RestTemplateBuilder();
	RestTemplate restTemplate = this.restTemplate(builder);

	@CacheEvict(value="customers", allEntries=true)
	public JsonElement getAllCustomers() {
		
		String resourceUrl = "http://localhost:8080/customers";
		String response = restTemplate.getForObject(resourceUrl, String.class);
		
		JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
		return ((JsonObject) jsonObject.get("_embedded")).get("customerList");
	}
	
	@Cacheable("customer")
	public JsonObject getOneCustomer(int id) {
		
		String resourceUrl = "http://localhost:8080/customers/" + id;
		resourceUrl.concat(Integer.toString(id));
		String response = restTemplate.getForObject(resourceUrl, String.class);
		
		JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
		return (jsonObject);
	}
	
	public Customer postCustomer(Customer customer) {
		
		String resourceUrl = "http://localhost:8080/customers";
		HttpEntity<Customer> request = new HttpEntity<>(customer);
		Customer posted = restTemplate.postForObject(resourceUrl, request, Customer.class);
		return posted;
	}
	
	public void deleteCustomer(int id) {
		
		String entityUrl = "http://localhost:8080/customers/" + id;
		restTemplate.delete(entityUrl);
	}
	
}
