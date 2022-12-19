package com.example.dagligvarer.delivery;


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

    @GetMapping
    private ResponseEntity<List<Delivery>> findAll() {
        return ResponseEntity.ok().body(deliveryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Delivery> save(@RequestBody Delivery delivery){
        return ResponseEntity.ok().body(deliveryService.save(delivery));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Delivery> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(deliveryService.delete(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Delivery> update(@RequestBody Delivery delivery, @PathVariable Long id) {
        return ResponseEntity.ok().body(deliveryService.update(delivery, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(deliveryService.findById(id));
    }

}
