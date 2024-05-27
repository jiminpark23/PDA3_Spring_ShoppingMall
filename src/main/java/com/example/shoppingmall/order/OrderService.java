package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;
    OrderJPARepository orderJPARepository;
    ProductJPARepository productJPARepository;

    public Order convertToEntity(OrderDTO orderDTO) {
        Product product = productJPARepository.findById(orderDTO.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + orderDTO.getProductId()));
        return new Order(product, orderDTO.getCount());
    }

    public void orderProduct(Order order) {
        orderJPARepository.save(order);
    }
}
