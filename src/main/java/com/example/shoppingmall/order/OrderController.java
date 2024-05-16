package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import com.example.shoppingmall.product.ProductService;
import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class OrderController {
    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
    public ResponseEntity orderProduct(@RequestBody OrderDTO orderDTO) {
        // DTO를 바로 service에게 주느냐 마느냐는 결정해야 함
        Product orderedProduct = productService.findProduct(orderDTO.getProductId());

        // TODO : Service로 이사갈 거예요. DTO -> Entity
        // 생성자 이용한 변환
        Order requestOrder = new Order(
                orderedProduct, orderDTO.getCount()
        );

        orderService.orderProduct(requestOrder);

        return new ResponseEntity<>(HttpStatus.CREATED);
//        if (Validator.isNumber(Integer.parseInt(order.getOrderNumber())) && Validator.isNumber(order.getCount())) {
//            Order savedOrder = orderService.save(order);
//
//            try {
//                log.info(savedOrder.getOrderNumber());
//            } catch (NullPointerException e) {
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//
//            return new ResponseEntity<>(savedOrder.getOrderNumber(), HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

    }
}
