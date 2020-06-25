package com.dhk.jpabase;

import com.dhk.jpabase.domain.DomainConfig;
import com.dhk.jpabase.infrastructure.InfraStructureConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableJpaRepositories(basePackageClasses = {InfraStructureConfig.class, DomainConfig.class})
public class JpabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpabaseApplication.class, args);
	}

}
