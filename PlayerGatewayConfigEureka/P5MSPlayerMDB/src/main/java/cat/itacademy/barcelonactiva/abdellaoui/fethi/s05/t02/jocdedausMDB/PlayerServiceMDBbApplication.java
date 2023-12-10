package cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t02.jocdedausMDB;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PlayerServiceMDBbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerServiceMDBbApplication.class, args);
	}

}
