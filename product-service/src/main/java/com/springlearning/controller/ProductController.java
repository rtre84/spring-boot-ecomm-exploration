package com.springlearning.controller;

import com.springlearning.model.Product;
import com.springlearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody Product product) {
        boolean saved = productService.save(product);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<Boolean> isExists(@RequestParam String name) {
        boolean exists = productService.isExists(name);
        return ResponseEntity.ok(exists);
    }
}
