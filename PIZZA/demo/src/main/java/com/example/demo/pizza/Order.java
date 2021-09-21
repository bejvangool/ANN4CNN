package com.example.demo.pizza;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    private Long order_id;
    private Long customer_id;
    private String status;
    private LocalDate ordered_at;
    private boolean takeaway;
    private String payment_type;
    @ElementCollection
    private List<Long> pizzas;

    public Order() {
    }

    public Order(Long order_id, Long customer_id, String status, boolean takeaway, String payment_type, List<Long> pizzas) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.status = status;
        this.ordered_at = LocalDate.now();
        this.takeaway = takeaway;
        this.payment_type = payment_type;
        //this.delivery_address = delivery_address;
        this.pizzas = pizzas;
    }

    public Order(Long customer_id, String status, boolean takeaway, String payment_type, List<Long> pizzas) {
        this.customer_id = customer_id;
        this.status = status;
        this.ordered_at = LocalDate.now();
        this.takeaway = takeaway;
        this.payment_type = payment_type;
        //this.delivery_address = delivery_address;
        this.pizzas = pizzas;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrdered_at() {
        return ordered_at;
    }

    public void setOrdered_at(LocalDate odered_at) {
        this.ordered_at = odered_at;
    }

    public boolean isTakeaway() {
        return takeaway;
    }

    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

//    public Address getDelivery_address() {
//        return delivery_address;
//    }
//
//    public void setDelivery_address(Address delivery_address) {
//        this.delivery_address = delivery_address;
//    }

    public List<Long> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Long> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", status='" + status + '\'' +
                ", ordered_at=" + ordered_at +
                ", takeaway=" + takeaway +
                ", payment_type='" + payment_type + '\'' +
                ", pizzas=" + pizzas +
                '}';
    }
}
