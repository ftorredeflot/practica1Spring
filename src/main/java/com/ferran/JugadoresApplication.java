package com.ferran;

import com.ferran.service.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JugadoresApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(JugadoresApplication.class, args);
		context.getBean(PlayerService.class).testPlayers();


	}
}
