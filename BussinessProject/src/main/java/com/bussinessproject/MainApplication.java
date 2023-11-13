package com.bussinessproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"entitys", "controllers",}
, //desactivando spring security 
exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class }
)


@RestController
//@EnableAutoConfiguration(exclude = {
////		DataSourceAutoConfiguration.class,
////		DataSourceTransactionManagerAutoConfiguration.class, 
////		HibernateJpaAutoConfiguration.class
//	})

// //@EnableDiscoveryClient


@ComponentScan({ "com.bussinessproject.controllers","com.bussinessproject.config" })
@EnableDiscoveryClient
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
