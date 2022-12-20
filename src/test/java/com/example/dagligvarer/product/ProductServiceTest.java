package com.example.dagligvarer.product;

import com.example.dagligvarer.product.model.Product;
import com.example.dagligvarer.product.repository.ProductRepository;
import com.example.dagligvarer.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;


    @Test
    public void fetchAllProductsTest(){


        // arrange, (all requirements such as lists, variables etc).
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Mælk",15.5,1000.0));
        productList.add(new Product("Chokolade",20.0,500.0));
        productList.add(new Product("Brød",25.0,800.0));
        when(productRepository.findAll()).thenReturn(productList);

        // act (operation gets executed)
        int products = productService.findAll().size(); // This is what we want to test

        // we are asserting that we have an x amount of products, and then pass the actual amount.
        assertEquals(3,products);
    }

    @Test
    public void saveProduct(){

        // arrange
        Product product = new Product("Slik",20.0,1500.0);
        when(productRepository.save(product)).thenReturn(product);

        // act
        Product savedProduct = productService.save(product);

        // assert
        assertEquals(product,savedProduct);
    }

    @Test
    public void updateProduct(){

        // Arrange
        Product product = new Product("Yoghurt", 16.5, 1000.0);
        product.setId(1L);

        Product newProduct = new Product();
        newProduct.setId(product.getId());
        newProduct.setName("Græsk-yoghurt");
        newProduct.setPrice(30.0);
        newProduct.setWeight(1500.0);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        // act
        Product updatedProduct = productService.update(newProduct,product.getId());

        verify(productRepository,times(1)).findById(1L);
        verify(productRepository,times(1)).save(product);
        verifyNoMoreInteractions(productRepository);

        // assert
        assertTrue(updatedProduct.getPrice() == 30.0);
    }




    @Test
    public void deleteProduct(){
        // Arrange
        Product product = new Product("Vand",3.0,1000.0);
        product.setId(2L);

        // act
        productService.delete(product.getId());
        verify(productRepository).deleteById(2L);
        Long productId = product.getId();

        // assert
        assertEquals(2L,productId);
    }

}
