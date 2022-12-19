package com.example.dagligvarer.order.service;


import com.example.dagligvarer.order.exception.OrderNotFoundException;
import com.example.dagligvarer.order.model.Order;
import com.example.dagligvarer.order.repository.OrderRepository;
import com.example.dagligvarer.product.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order){
        return orderRepository.save(order);

    }

    public Order delete(Long id){
        orderRepository.deleteById(id);
        return null;
    }

    public Order update(Order order, Long id){
        Order existingOrder = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order not found: " + id));
        if (order.getQuantity()!= null) existingOrder.setQuantity(order.getQuantity());
        if (order.getProduct().getId() != null) existingOrder.setProduct(new Product(order.getProduct().getId()));
        return orderRepository.save(existingOrder);
    }

    public Order findById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Product " + id+ " was not found"));
        return order;
    }
}
