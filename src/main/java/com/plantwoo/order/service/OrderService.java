package com.plantwoo.order.service;

import com.plantwoo.order.model.Order;
import com.plantwoo.order.repository.ReactiveOrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    ReactiveOrderRepository reactiveOrderRepository;

    public Mono<Order> insertUpdate(Order order) {
      return reactiveOrderRepository.save(order);
    }

    public Flux<Order> bulkCreate(List<Order> orders) {
        return reactiveOrderRepository.saveAll(orders);
    }

    public Mono<Order> getOrder(ObjectId orderId) {
        return reactiveOrderRepository.findById(orderId);
    }

    public Flux<Order> getOrders(String customerId) {
        return reactiveOrderRepository.findAll();
    }

    public Mono<Void> delete(ObjectId orderId) {
        return reactiveOrderRepository.deleteById(orderId);
    }

}
