package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "hardCodedMethod")
//	@CircuitBreaker(name = "default", fallbackMethod = "hardCodedMethod")
//	@RateLimiter(name = "default")
	@Bulkhead(name = "sample-api")
	public String sampleApi() {
		logger.info("sample api call recived");

//		  ResponseEntity<String> forEntity = new
//		  RestTemplate().getForEntity("http://localhost:8080/hello", String.class);
//		  return forEntity.getBody();
		return "sample api";
	}

	public String hardCodedMethod(Exception ex) {
		return "fallback-response";
	}
}
