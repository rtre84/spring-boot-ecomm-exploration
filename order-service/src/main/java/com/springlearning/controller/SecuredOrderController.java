package com.springlearning.controller;

import com.springlearning.OrderServiceApplication;
import com.springlearning.model.Order;
import com.springlearning.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "secured/order")
public class SecuredOrderController {

    @Autowired
    OrderService orderService;

//    @Autowired
//    OrderServiceApplication.OOrderUserDetailsService orderUserDetailsService;

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody Order order) {
        if (orderService.save(order)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            throw new OrderService.OrderNotCreatedException();
        }
    }

    @GetMapping
    public ResponseEntity<Optional<Order>> isExists(@RequestParam String userId) {
        Optional<Order> exists = orderService.findByUserId(userId);
        return ResponseEntity.ok(exists);
    }
}
