package com.ProgIV.Prode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

@SpringBootApplication
@EnableScheduling

public class ProdeApplication {

	public static void main(String[] args) {

		
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		
		for (DotenvEntry entry : dotenv.entries()) {
			System.setProperty(entry.getKey(), entry.getValue());
		}
		
		SpringApplication.run(ProdeApplication.class, args);
	}

}
