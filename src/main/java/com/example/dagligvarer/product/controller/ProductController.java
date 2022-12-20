package com.example.dagligvarer.product.controller;

import com.example.dagligvarer.dto.ProductDto;
import com.example.dagligvarer.factory.DtoFactory;
import com.example.dagligvarer.product.model.Product;
import com.example.dagligvarer.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final DtoFactory dtoFactory;


    @GetMapping
    private ResponseEntity<List<ProductDto>> findAll() {
        return ResponseEntity.ok().body(dtoFactory.fromProducts(productService.findAll()));
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody Product product){
        return ResponseEntity.ok().body(dtoFactory.fromProduct(productService.save(product)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.delete(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductDto> update(@RequestBody Product product, @PathVariable Long id) {
        return ResponseEntity.ok().body(dtoFactory.fromProduct(productService.update(product, id)));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(dtoFactory.fromProduct(productService.findById(id)));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<ProductDto> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(dtoFactory.fromProduct(productService.findByName(name)));
    }
}
