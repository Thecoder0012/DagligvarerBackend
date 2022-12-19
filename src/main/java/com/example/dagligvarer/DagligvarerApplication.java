package com.example.dagligvarer;

import com.example.dagligvarer.delivery.Delivery;
import com.example.dagligvarer.delivery.DeliveryRepository;
import com.example.dagligvarer.order.model.Order;
import com.example.dagligvarer.order.repository.OrderRepository;
import com.example.dagligvarer.product.model.Product;
import com.example.dagligvarer.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
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
    CommandLineRunner run(OrderRepository orderRepository, ProductRepository productRepository, DeliveryRepository deliveryRepository){
        return args -> {
            Product chokolade = new Product("Chokolade",25.0,500.0);
            Product tomat = new Product("Tomat",15.0,800.0);
            Product salat = new Product("Salat",20.0,500.0);

            productRepository.saveAll(List.of(chokolade,tomat,salat));
            log.info("Products added");

            Delivery netto = new Delivery(LocalDateTime.now(),"Lager1","Netto");
            Delivery rema = new Delivery(LocalDateTime.now(),"Lager2","Rema");
            Delivery aldi = new Delivery(LocalDateTime.now(),"Lager3","Aldi");

            deliveryRepository.saveAll(List.of(netto,rema,aldi));
            log.info("Deliveries added");

            Order order = new Order(200,chokolade,netto);
            Order order1 = new Order(100,tomat,rema);
            Order order2 = new Order(70,salat,aldi);

            orderRepository.saveAll(List.of(order,order1,order2));
            log.info("orders added");
        };
    }

}
