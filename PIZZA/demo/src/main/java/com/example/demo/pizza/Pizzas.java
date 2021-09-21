package com.example.demo.pizza;

import java.util.List;




public class Pizzas {
    private List<PizzaOrder> pizzaOrderList;

    public Pizzas(List<PizzaOrder> pizzaOrderList) {
        this.pizzaOrderList = pizzaOrderList;
    }

    public List<PizzaOrder> getPizzaOrderList() {
        return pizzaOrderList;
    }

    public void setPizzaOrderList(List<PizzaOrder> pizzaOrderList) {
        this.pizzaOrderList = pizzaOrderList;
    }
}
