package com.example.demo.pizza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner commandLineRunnerOrder(OrderRepository repository){
        return args -> {
        };
    }

}
