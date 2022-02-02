package com.sparta.wekk043thproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Wekk043thProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Wekk043thProjectApplication.class, args);
    }

}
