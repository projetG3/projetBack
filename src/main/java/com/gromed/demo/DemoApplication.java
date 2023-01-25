package com.gromed.demo;

import com.gromed.demo.model.Titulaire;
import com.gromed.demo.service.TitulaireService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;

import java.util.Optional;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOK");

		TitulaireService titulaireService = new TitulaireService();
		Titulaire test = new Titulaire();
		test.setId("mon testééé");
		titulaireService.saveTitulaire(test);
		System.out.println("ADD TITULAIRE OK");


	}
}
