package com.example.dagligvarer.delivery.model;

import com.example.dagligvarer.order.model.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Delivery {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime deliveryDate;
    private String wareHouse;
    private String destination;

    public Delivery(LocalDateTime deliveryDate, String wareHouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.wareHouse = wareHouse;
        this.destination = destination;
    }

    @OneToMany(mappedBy = "delivery",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders;
}
