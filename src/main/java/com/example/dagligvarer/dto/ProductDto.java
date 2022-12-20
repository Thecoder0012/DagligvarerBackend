package com.example.dagligvarer.dto;

import com.example.dagligvarer.order.model.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String name;
    private Double price;
    private Double weight;
    @JsonIgnore
    private List<OrderDto> orders;

}
