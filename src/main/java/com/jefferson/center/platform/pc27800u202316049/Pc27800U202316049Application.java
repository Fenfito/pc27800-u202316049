package com.jefferson.center.platform.pc27800u202316049;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.jefferson.center.platform")
@EntityScan(basePackages = "com.jefferson.center.platform")
@EnableJpaRepositories(basePackages = "com.jefferson.center.platform")
public class Pc27800U202316049Application {

    public static void main(String[] args) {
        SpringApplication.run(Pc27800U202316049Application.class, args);
    }

}
