package com.plantwoo.order.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Order {
    @Id
    private ObjectId _id;
    private String productId;
    private String customerId;
    private BigDecimal price;
    private String status;
}
