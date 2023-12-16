package ru.karmazin.barometerbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BarometerBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(BarometerBotApplication.class, args);
    }

}
