package com.example.dagligvarer.delivery.controller;


import com.example.dagligvarer.delivery.service.DeliveryService;
import com.example.dagligvarer.delivery.model.Delivery;
import com.example.dagligvarer.dto.DeliveryDto;
import com.example.dagligvarer.factory.DtoFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final DtoFactory dtoFactory;

    @GetMapping
    private ResponseEntity<List<DeliveryDto>> findAll() {
        return ResponseEntity.ok().body(dtoFactory.fromDeliveries(deliveryService.findAll()));
    }

    @PostMapping
    public ResponseEntity<DeliveryDto> save(@RequestBody Delivery delivery){
        return ResponseEntity.ok().body(dtoFactory.fromDelivery(deliveryService.save(delivery)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Delivery> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(deliveryService.delete(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DeliveryDto> update(@RequestBody Delivery delivery, @PathVariable Long id) {
        return ResponseEntity.ok().body(dtoFactory.fromDelivery(deliveryService.update(delivery, id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(dtoFactory.fromDelivery(deliveryService.findById(id)));
    }
}
