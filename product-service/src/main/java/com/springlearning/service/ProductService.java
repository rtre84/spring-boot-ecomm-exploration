package com.springlearning.service;

import com.springlearning.model.Product;
import com.springlearning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean save(Product product) {
        return productRepository.save(product) != null;
    }

    public boolean isExists(String name) {
        return productRepository.findByName(name).isPresent();
    }

}
