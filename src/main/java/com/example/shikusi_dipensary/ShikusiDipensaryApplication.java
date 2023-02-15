package com.example.shikusi_dipensary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})

public class ShikusiDipensaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShikusiDipensaryApplication.class, args);
    }

}
