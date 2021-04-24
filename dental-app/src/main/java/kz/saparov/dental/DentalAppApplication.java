package kz.saparov.dental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalAppApplication.class, args);
	}
	
	/*
	 * netstat -ano | findstr 8080
	 * 
	 * taskkill /F /PID xx
	 * 
	 */

}
