package com.example.demo.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrder(){
        return orderRepository.findAll();
    }

    public void addNewOrder(Order order) {
        System.out.println(order);
    }
}
