package com.springlearning.service;

import com.springlearning.model.Product;
//import com.springlearning.service.ProductService;
import com.springlearning.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

class ProductServiceTest {

    ProductService productService = new ProductService();

    @BeforeEach
    public void setup() {
        productService = new ProductService();
        productService.productRepository = Mockito.mock(ProductRepository.class);
    }

    @Test
    void save() {
        String name = "Product Save Test";
        String description = "Product test description";

        Product product = Product.builder()
                .name(name)
                .description(description)
                .build();

        Mockito.when(productService.productRepository.save(Mockito.any())).thenReturn(new Product());

        boolean saved = productService.save(product);
        Assertions.assertThat(saved).isTrue();
    }

    @Test
    void isExists() {
        String name = "Product Exist Test";
        String description = "Product test description";

        Product product = Product.builder()
                .name(name)
                .description(description)
                .build();

        Mockito.when(productService.productRepository.save(Mockito.any())).thenReturn(new Product());
        productService.save(product);

        boolean exists = productService.isExists(name);
        Assertions.assertThat(exists).isTrue();
    }
}