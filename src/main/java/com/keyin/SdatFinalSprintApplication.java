package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class SdatFinalSprintApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdatFinalSprintApplication.class, args);
	}

}
