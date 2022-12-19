package com.example.dagligvarer.product.repository;

import com.example.dagligvarer.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Optional<Product> findByName(String name);
}
