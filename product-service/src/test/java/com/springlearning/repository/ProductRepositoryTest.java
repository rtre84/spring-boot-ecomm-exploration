package com.springlearning.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springlearning.model.Product;

import java.util.Optional;


@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testProductRepository() {
        Product product = Product.builder()
                .name("Product Test")
                .description("Product test description")
                .build();

        productRepository.save(product);

        Assertions.assertThat(productRepository.findAll().stream().findAny().get()).isEqualTo(product);
    }

    @Test
    public void shouldCheckAProductByName() {
        Product product = Product.builder()
                .name("Some name")
                .description("Some description")
                .build();

        productRepository.save(product);
        Optional<Product> productOptional = productRepository.findByName(product.getName());

        Assertions.assertThat(productOptional.get()).isEqualTo(product);
    }
}