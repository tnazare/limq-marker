package com.limq.marker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.limq"})
public class MarkerApplication
{
    public static void main(String[] args) {
        SpringApplication.run(MarkerApplication.class, args);
    }
}
