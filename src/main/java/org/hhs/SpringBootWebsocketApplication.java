package org.hhs;

import org.hhs.config.WebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class SpringBootWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebsocketApplication.class, args);
	}
}
