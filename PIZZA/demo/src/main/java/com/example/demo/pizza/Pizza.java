package com.example.demo.pizza;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Pizza {
    @Id
    @SequenceGenerator(
            name = "pizza_sequence",
            sequenceName = "pizza_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pizza_sequence"
    )
    private Long pizza_id;
    private String name;
    private boolean vegetarian;
    private double price;
    @ElementCollection
    private List<String> toppings;

    public Pizza() {
    }

    public Pizza(Long pizza_id, String name, boolean vegetarian, double price, List<String> toppings) {
        this.pizza_id = pizza_id;
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
        this.toppings = toppings;
    }

    public Pizza(String name, boolean vegetarian, double price, List<String> toppings) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
        this.toppings = toppings;
    }

    public Pizza(Long pizza_id, String name, boolean vegetarian, double price) {
        this.pizza_id = pizza_id;
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public Long getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(Long pizza_id) {
        this.pizza_id = pizza_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizza_id=" + pizza_id +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", price=" + price +
                ", toppings=" + toppings +
                '}';
    }
}

