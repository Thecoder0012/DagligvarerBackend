package com.example.dagligvarer.order.controller;

import com.example.dagligvarer.dto.OrderDto;
import com.example.dagligvarer.factory.DtoFactory;
import com.example.dagligvarer.order.model.Order;
import com.example.dagligvarer.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final DtoFactory dtoFactory;

    @GetMapping
    private ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok().body(dtoFactory.fromOrders(orderService.findAll()));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody Order order){
        return ResponseEntity.ok().body(dtoFactory.fromOrder(orderService.save(order)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.delete(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDto> update(@RequestBody Order order, @PathVariable Long id) {
        return ResponseEntity.ok().body(dtoFactory.fromOrder(orderService.update(order, id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(dtoFactory.fromOrder(orderService.findById(id)));
    }

}
