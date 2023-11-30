package sv.edu.ufg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(SecurityConfig.class)
@ComponentScan(basePackages = "sv.edu.sv.controllers")
public class CrudClinicaVeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudClinicaVeterinariaApplication.class, args);
	}

}
