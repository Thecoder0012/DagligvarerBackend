package com.example.dagligvarer.delivery;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    public Delivery save(Delivery delivery){
        return deliveryRepository.save(delivery);

    }

    public Delivery delete(Long id){
        deliveryRepository.deleteById(id);
        return null;
    }

    public Delivery update(Delivery delivery, Long id){
        Delivery existingDelivery = deliveryRepository.findById(id).orElseThrow(()->new RuntimeException("Delivery not found: " + id));
        if (existingDelivery.getDeliveryDate() != null) existingDelivery.setDeliveryDate(delivery.getDeliveryDate());
        if (existingDelivery.getWareHouse() != null) existingDelivery.setWareHouse(delivery.getWareHouse());
        if (existingDelivery.getDestination() != null) existingDelivery.setDestination(delivery.getDestination());
        return deliveryRepository.save(existingDelivery);
    }

    public Delivery findById(Long id){
        Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery " + id+ " was not found"));
        return delivery;
    }
}
