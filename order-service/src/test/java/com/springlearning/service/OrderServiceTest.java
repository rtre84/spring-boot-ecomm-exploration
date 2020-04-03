package com.springlearning.service;

import com.springlearning.model.Order;
import com.springlearning.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class OrderServiceTest {

    OrderService orderService = new OrderService();

    @BeforeEach
    public void setup() {
        orderService = new OrderService();
        orderService.orderRepository = Mockito.mock(OrderRepository.class);
    }

    @Test
    void save() {

        Order.ProductDetail productDetail = Order.ProductDetail.builder()
                .code(23123)
                .description("sdsdssd")
                .name("ds")
                .build();

        Order order = Order.builder()
                .userId("1231231asdsa")
                .address("zczxczcxzczcz")
                .quantity(3)
                .productDetail(productDetail)
                .build();

        Mockito.when(orderService.orderRepository.save(Mockito.any())).thenReturn(new Order());

        boolean saved = orderService.save(order);
        Assertions.assertThat(saved).isTrue();
    }

    @Test
    void isExists() {

        Order.ProductDetail productDetail = Order.ProductDetail.builder()
                .code(23123)
                .description("sdsdssd")
                .name("ds")
                .build();

        Order order = Order.builder()
                .id(13313)
                .userId("1231231asdsa")
                .address("zczxczcxzczcz")
                .quantity(3)
                .productDetail(productDetail)
                .build();

        Mockito.when(orderService.orderRepository.save(Mockito.any())).thenReturn(new Order());
        orderService.save(order);

        boolean exists = orderService.isExists(13313);
        Assertions.assertThat(exists).isTrue();
    }
}