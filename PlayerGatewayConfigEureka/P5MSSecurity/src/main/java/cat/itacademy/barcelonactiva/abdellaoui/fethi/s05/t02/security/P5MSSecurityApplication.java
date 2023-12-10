package cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t02.security;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t02.security.entities.AppRole;
import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t02.security.entities.AppUser;
import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t02.security.services.AccountService;
import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t02.security.Config.RsaKeysConfiguration;

@EnableConfigurationProperties(RsaKeysConfiguration.class)
@EnableMethodSecurity
@SpringBootApplication
@EnableDiscoveryClient
public class P5MSSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(P5MSSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner star(AccountService accountService) {
		return args -> {

			
			accountService.addRole(new AppRole(null, "PLAYER"));
			accountService.addRole(new AppRole(null, "ADMIN"));
			accountService.addRole(new AppRole(null, "USER"));

			accountService.addUser(new AppUser(null, "player1", "1234", new ArrayList<>()));
			accountService.addUser(new AppUser(null, "player2", "1234", new ArrayList<>()));
			accountService.addUser(new AppUser(null, "player3", "1234", new ArrayList<>()));
			accountService.addUser(new AppUser(null, "admin", "1234", new ArrayList<>()));

			accountService.addRoleToUser("admin", "ADMIN");
			accountService.addRoleToUser("admin", "PLAYER");

			accountService.addRoleToUser("player1", "PLAYER");
			accountService.addRoleToUser("player2", "PLAYER");
			accountService.addRoleToUser("player3", "PLAYER");

		};
	}



}
