package com.springlearning.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import com.springlearning.model.Order;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testOrderRepository() {
        Order.ProductDetail testProductDetail = Order.ProductDetail.builder()
                .code(234)
                .name("Test Product")
                .description("Test Product Description")
                .build();

        Order order = Order.builder()
                .id(1)
                .userId("iab23")
                .quantity(322)
                .address("Test Address")
                .productDetail(testProductDetail)
                .build();

        orderRepository.save(order);

        Assertions.assertThat(orderRepository.findAll().stream().findAny().get()).isEqualTo(order);
    }

    @Test
    public void shouldCheckAnOrderByID() {
        Order.ProductDetail testProductDetail = Order.ProductDetail.builder()
                .code(234)
                .name("Test Product")
                .description("Test Product Description")
                .build();

        Order order = Order.builder()
                .id(1)
                .userId("iab23")
                .quantity(322)
                .address("Test Address")
                .productDetail(testProductDetail)
                .build();

        orderRepository.save(order);
        Optional<Order> orderOptional = orderRepository.findById(order.getId());

        Assertions.assertThat(orderOptional.get()).isEqualTo(order);
    }
}