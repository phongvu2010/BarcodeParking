package ga.hunterdo.barcodeparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BarcodeParkingApplication {
	public static void main(String[] args) {
		SpringApplication.run(BarcodeParkingApplication.class, args);
	}
}