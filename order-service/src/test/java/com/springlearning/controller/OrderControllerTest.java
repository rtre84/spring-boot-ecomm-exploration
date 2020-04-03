package com.springlearning.controller;

import com.springlearning.model.Order;
import com.springlearning.repository.OrderRepository;
import com.springlearning.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class OrderControllerTest {

    OrderService orderService = new OrderService();

    @BeforeEach
    void setUp() {
        orderService = Mockito.mock(OrderService.class);
    }

    @Test
    void save() {

    }

    @Test
    void isExists() {
    }
}