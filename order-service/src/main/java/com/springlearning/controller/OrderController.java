package com.springlearning.controller;

import com.springlearning.model.Order;
import com.springlearning.service.OrderService;
import com.springlearning.service.OrderService.OrderNotCreatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody Order order) {
        if (orderService.save(order)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            throw new OrderNotCreatedException();
        }
    }

    @GetMapping
    public ResponseEntity<Boolean> isExists(@RequestParam String userId) {
        boolean exists = orderService.findByUserId(userId);
        return ResponseEntity.ok(exists);
    }
}
