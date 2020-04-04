package com.springlearning.service;

import com.springlearning.model.Order;
import com.springlearning.producer.Sender;
import com.springlearning.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Sender sender;

    public boolean save(Order order) {
//        ResponseEntity<Boolean> forEntity = restTemplate.getForEntity("http://product-service/product?name=" + order.getProductDetail().getName(), Boolean.class);
        ResponseEntity<Order.ProductDetail> forEntity = restTemplate.getForEntity("http://product-service/product?name=" + order.getProductDetail().getName(), Order.ProductDetail.class);

        if (forEntity.hasBody()) {
            Order saved = orderRepository.save(order);
            if (saved != null) {
                sender.send("Order Id: " + order.getId().toString());
                return true;
            } else {
                throw new OrderNotCreatedException();
            }
        }
        else {
            throw new ProductNotFoundException();
        }

    }

    public boolean isExists(Integer orderId) {
        return orderRepository.findById(orderId) != null;
    }

    public boolean findByUserId(String userId) {
        return orderRepository.findByUserId(userId) != null;
    }

    public static class OrderNotCreatedException extends RuntimeException {
    }

    public static class ProductNotFoundException extends RuntimeException {}

}
