package com.example.demo.pizza;

public class PizzaOrder {
    private Long Pizza_id;
    private String note;

    public PizzaOrder(Long pizza_id, String note) {
        Pizza_id = pizza_id;
        this.note = note;
    }

    public Long getPizza_id() {
        return Pizza_id;
    }

    public void setPizza_id(Long pizza_id) {
        Pizza_id = pizza_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
