package com.example.dagligvarer.dto;

import com.example.dagligvarer.delivery.model.Delivery;
import com.example.dagligvarer.product.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Integer quantity;
    private ProductDto product;
    private DeliveryDto delivery;
}
