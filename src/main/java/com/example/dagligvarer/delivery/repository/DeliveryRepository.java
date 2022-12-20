package com.example.dagligvarer.delivery.repository;

import com.example.dagligvarer.delivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
