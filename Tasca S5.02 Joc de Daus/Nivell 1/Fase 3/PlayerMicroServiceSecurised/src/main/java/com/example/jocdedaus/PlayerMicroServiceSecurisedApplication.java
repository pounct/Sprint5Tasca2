package com.example.jocdedaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.jocdedaus.config.RsaKeyConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfiguration.class)
public class PlayerMicroServiceSecurisedApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerMicroServiceSecurisedApplication.class, args);
	}

}
