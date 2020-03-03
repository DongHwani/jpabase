package com.dhk.jpabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpabaseApplication.class, args);
	}

}
