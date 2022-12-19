package com.example.dagligvarer.order.repository;

import com.example.dagligvarer.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
