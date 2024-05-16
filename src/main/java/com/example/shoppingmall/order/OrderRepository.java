package com.example.shoppingmall.order;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
@JsonNaming
public class OrderRepository {
    private Map<Integer, Order> orderTable = new HashMap<>();
    private int id = 0;

    public void saveOrder(Order order) {
        log.info("productName = {}", order.getProduct().getName());
        log.info("count = {}", order.getCount());

        order.setId(id++);
        orderTable.put(order.getId(), order);

//        return orderTable.get(id-1);
    }
}
