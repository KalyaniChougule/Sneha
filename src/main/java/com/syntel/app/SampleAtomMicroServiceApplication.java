package com.syntel.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The Class SampleMicroServiceApplication. This is first class which will loaded with the application start up
 * Important annotations:
 * 1. @SpringBootApplication to declare this class as Spring boot start up class
 * 2. @EnableDiscoveryClient to register this application with Service Discovery
 * 3. @ComponentScan use this to mention all folders which will contain Spring components 
 */
@SpringBootApplication		 
//@EnableDiscoveryClient		
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.syntel.*"})

public class SampleAtomMicroServiceApplication  {
	
	private static final Logger LOG = LoggerFactory
			.getLogger(SampleAtomMicroServiceApplication.class);
 
	/**
	 * SpringApplication.run() will start spring boot application  
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOG.info("Starting up SampleAtomMicroService Application...");
		SpringApplication.run(SampleAtomMicroServiceApplication.class, args);
		LOG.info("Stopping the  SampleAtomMicroService Application...");
	}
	
	
}
