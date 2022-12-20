package com.example.dagligvarer.dto;

import com.example.dagligvarer.order.model.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class DeliveryDto {

    private Long id;
    private LocalDateTime deliveryDate;
    private String wareHouse;
    private String destination;
    @JsonIgnore
    private List<OrderDto> orders;


}
