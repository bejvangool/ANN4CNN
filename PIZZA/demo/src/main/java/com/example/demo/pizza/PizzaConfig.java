package com.example.demo.pizza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PizzaConfig {

    @Bean
    CommandLineRunner commandLineRunnerPizza(PizzaRepository repository) {
        return args -> {
            Pizza margherita = new Pizza(
                    "Margherita",
                    true,
                    10.50,
                    List.of("Tomato","Mozzarella")
            );

            Pizza funghi = new Pizza(
                    "Funghi",
                    true,
                    11.50,
                    List.of("Tomato","Mozzarella","Mushrooms")
            );

            Pizza napoletana = new Pizza(
                    "Napoletana",
                    false,
                    12.50,
                    List.of("Tomato","Mozzarella","Olives","Anchovies","Capers")
            );

            repository.saveAll(
                    List.of(margherita, funghi, napoletana)
            );
        };
    }
}
