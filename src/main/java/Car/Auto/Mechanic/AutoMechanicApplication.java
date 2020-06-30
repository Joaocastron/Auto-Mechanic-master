package Car.Auto.Mechanic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"Car.Auto.Mechanic"})
public class AutoMechanicApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoMechanicApplication.class, args);
	}

}
