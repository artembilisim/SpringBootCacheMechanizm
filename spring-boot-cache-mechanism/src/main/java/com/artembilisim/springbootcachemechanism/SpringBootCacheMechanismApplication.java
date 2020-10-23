package com.artembilisim.springbootcachemechanism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCacheMechanismApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheMechanismApplication.class, args);
    }

}
