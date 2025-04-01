package com.shr.food.place;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author MSA
 * @version 1.0
 */

@EnableAsync
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.shr.food.place.*")
public class FoodPlaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodPlaceApplication.class, args);
    }
}