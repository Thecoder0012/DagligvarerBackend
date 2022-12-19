package com.example.dagligvarer.order.controller;

import com.example.dagligvarer.order.model.Order;
import com.example.dagligvarer.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/v1/order")
public class OrderController {

    private final OrderService orderService;


    @GetMapping
    private ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order){
        return ResponseEntity.ok().body(orderService.save(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.delete(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Order> update(@RequestBody Order order, @PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.update(order, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findById(id));
    }

}
