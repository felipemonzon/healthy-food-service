package com.moontech.healthyfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HealthyFoodServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(HealthyFoodServiceApplication.class, args);
  }
}
