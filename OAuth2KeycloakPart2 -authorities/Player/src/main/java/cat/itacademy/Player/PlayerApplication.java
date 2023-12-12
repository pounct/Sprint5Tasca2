package cat.itacademy.Player;

import cat.itacademy.Player.entities.Player;
import cat.itacademy.Player.repoitories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class PlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerApplication.class, args);
	}

	@Bean
	CommandLineRunner star(PlayerRepository playerRepository) {
		return args -> {

			playerRepository.saveAll(List.of(
					Player.builder().username("pounct").email("pounct@gmail.com").registrationDate(LocalDateTime.now()).build(),
					Player.builder().username("player1").email("fonexp16@gmail.com").registrationDate(LocalDateTime.now()).build(),
					Player.builder().username("player2").email("player2@gmail.com").registrationDate(LocalDateTime.now()).build(),
					Player.builder().username("player2").email("player2@gmail.com").registrationDate(LocalDateTime.now()).build()
			));
		};
	}

}
