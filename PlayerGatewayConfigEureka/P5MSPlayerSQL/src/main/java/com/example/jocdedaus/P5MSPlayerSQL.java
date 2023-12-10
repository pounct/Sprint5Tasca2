package com.example.jocdedaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class P5MSPlayerSQL {

	public static void main(String[] args) {
		SpringApplication.run(P5MSPlayerSQL.class, args);
	}

}
