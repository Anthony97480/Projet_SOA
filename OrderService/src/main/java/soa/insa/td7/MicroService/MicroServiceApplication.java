package soa.insa.td7.MicroService;

import soa.insa.td7.MicroService.bdd.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroServiceApplication {

	public static void main(String[] args) {
		String db_URL = "jdbc:sqlite:e_commerce.db";

		DatabaseInit.init(db_URL);

		SpringApplication.run(MicroServiceApplication.class, args);
	}

}
