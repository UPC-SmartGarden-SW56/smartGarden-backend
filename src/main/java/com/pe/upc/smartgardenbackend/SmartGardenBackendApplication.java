package com.pe.upc.smartgardenbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SmartGardenBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartGardenBackendApplication.class, args);
    }

}
