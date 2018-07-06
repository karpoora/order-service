package com.plantwoo.order.controller;

import com.plantwoo.order.model.Order;
import com.plantwoo.order.service.OrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    Mono<Order> create(@RequestBody Order order){
       return orderService.insertUpdate(order);
    }

    @PutMapping("/order")
    Mono<Order> update(@RequestBody Order order){
        return orderService.insertUpdate(order);
    }

    @PostMapping("/orders")
    Flux<Order> bulkCreate(@RequestBody List<Order> orders){
        return orderService.bulkCreate(orders);
    }

    @DeleteMapping("/order/{orderId}")
    Mono<Void> delete(@PathVariable ObjectId orderId){
        return orderService.delete(orderId);
    }

    @GetMapping("/order/{orderId}")
    Mono<Order> getOrder(@PathVariable ObjectId orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping("/orders/{customerId}")
    Flux<Order> getOrders(@RequestParam String customerId){
        return orderService.getOrders(customerId);
    }
}
