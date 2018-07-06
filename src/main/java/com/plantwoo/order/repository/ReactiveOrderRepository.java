package com.plantwoo.order.repository;

import com.plantwoo.order.model.Order;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveOrderRepository extends ReactiveMongoRepository<Order, ObjectId> {
    Mono<Order> findById(ObjectId id);
}
