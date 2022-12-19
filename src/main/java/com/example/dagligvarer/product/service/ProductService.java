package com.example.dagligvarer.product.service;

import com.example.dagligvarer.product.exception.ProductNotFoundException;
import com.example.dagligvarer.product.model.Product;
import com.example.dagligvarer.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product delete(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    public Product update(Product product, Long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product " + id+ " was not found"));
        if (product.getName() != null) existingProduct.setName(product.getName());
        if (product.getPrice() != null) existingProduct.setPrice(product.getPrice());
        if (product.getWeight() != null) existingProduct.setWeight(product.getWeight());
        return productRepository.save(existingProduct);
    }

    public Product findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product " + id+ " was not found"));
        return product;
    }

    public Product findByName(String name){
        Product product = productRepository.findByName(name).orElseThrow(() -> new ProductNotFoundException("Product " + name+ " was not found"));
        return product;
    }
}
