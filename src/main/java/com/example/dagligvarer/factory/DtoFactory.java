package com.example.dagligvarer.factory;

import com.example.dagligvarer.delivery.model.Delivery;
import com.example.dagligvarer.dto.DeliveryDto;
import com.example.dagligvarer.dto.OrderDto;
import com.example.dagligvarer.dto.ProductDto;
import com.example.dagligvarer.order.model.Order;
import com.example.dagligvarer.product.model.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DtoFactory {

    private final ModelMapper modelMapper;

    public ProductDto fromProduct(Product product){
        return modelMapper.map(product,ProductDto.class);
    }

    public List<ProductDto> fromProducts(List<Product> products){
        return products.stream()
                .map(product -> fromProduct(product))
                .collect(Collectors.toList());
    }

    public DeliveryDto fromDelivery(Delivery delivery){
        return modelMapper.map(delivery,DeliveryDto.class);
    }

    public List<DeliveryDto> fromDeliveries(List<Delivery> deliveries){
        return deliveries.stream()
                .map(delivery -> fromDelivery(delivery))
                .collect(Collectors.toList());
    }

    public OrderDto fromOrder(Order order){
        return modelMapper.map(order,OrderDto.class);
    }

    public List<OrderDto> fromOrders(List<Order> orders){
        return orders.stream()
                .map(order -> fromOrder(order))
                .collect(Collectors.toList());
    }




}
