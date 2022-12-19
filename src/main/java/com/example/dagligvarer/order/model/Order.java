package com.example.dagligvarer.order.model;


import com.example.dagligvarer.product.model.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id",nullable = false)
    private Product product;

    public Order(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }


}
