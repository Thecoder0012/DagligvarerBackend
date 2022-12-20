package com.example.dagligvarer;

import com.example.dagligvarer.delivery.model.Delivery;
import com.example.dagligvarer.delivery.repository.DeliveryRepository;
import com.example.dagligvarer.order.model.Order;
import com.example.dagligvarer.order.repository.OrderRepository;
import com.example.dagligvarer.product.model.Product;
import com.example.dagligvarer.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DagligvarerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagligvarerApplication.class, args);
    }

    @Bean
    public static ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner run(OrderRepository orderRepository, ProductRepository productRepository, DeliveryRepository deliveryRepository){
        return args -> {
            Product chokolade = new Product("Chokolade",25.0,500.0);
            Product tomat = new Product("Tomat",15.0,800.0);
            Product salat = new Product("Salat",20.0,500.0);

            productRepository.saveAll(List.of(chokolade,tomat,salat));
            log.info("Products added");

            Delivery delivery1 = new Delivery(LocalDateTime.now(),"CphLager","Jesper Nielsen, Fredriksundsvej 25");
            Delivery delivery2 = new Delivery(LocalDateTime.now(),"ExpressLager","Bob Johnson, Østerbrogade 100");
            Delivery delivery3 = new Delivery(LocalDateTime.now(),"Varelager","Christine Hansen, Nørrebrogade 30");

            deliveryRepository.saveAll(List.of(delivery1,delivery2,delivery3));
            log.info("Deliveries added");

            Order order = new Order(200,chokolade,delivery1);
            Order order1 = new Order(100,tomat,delivery2);
            Order order2 = new Order(70,salat,delivery3);

            orderRepository.saveAll(List.of(order,order1,order2));
            log.info("orders added");
        };
    }

}
