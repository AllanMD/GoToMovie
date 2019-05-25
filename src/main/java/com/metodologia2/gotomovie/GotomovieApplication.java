package com.metodologia2.gotomovie;

import com.metodologia2.gotomovie.controller.JsonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GotomovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(GotomovieApplication.class, args);

		//JsonController.readObjectMovie();
	}

}
