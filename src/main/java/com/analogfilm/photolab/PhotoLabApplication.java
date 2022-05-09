package com.analogfilm.photolab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.analogfilm.photolab.repository")
@EntityScan(basePackages = "com.analogfilm.photolab.models")
public class PhotoLabApplication {

    public static void main(String[] args) {

        SpringApplication.run(PhotoLabApplication.class, args);
    }
}
