package com.springlearning.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.springlearning.model.Product;
import com.springlearning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Jedis jedis;

    public boolean save(Product product) {
        return productRepository.save(product) != null;
    }

    public boolean isExists(String name) {
        return productRepository.findByName(name).isPresent();
    }

    public Product get(String name) {
        //If it is found in cache
        if (jedis.exists(name)) {
            //Read from cache
            String productRedisJson = jedis.get(name);
            ObjectMapper objectMapper = new ObjectMapper();
            try {

                Product readProduct = objectMapper.readValue(productRedisJson, Product.class);
                System.out.println("Fetched from Redis: " + readProduct);
                return readProduct;

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        else {
            //Not found in cache
            //read from DB
            Product fetchedProduct = productRepository.findByName(name).get();
            ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();;
            try {
                String productJson = objectWriter.writeValueAsString(fetchedProduct);

                //write to redis
                jedis.append(name, productJson);

                return fetchedProduct;

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

}
