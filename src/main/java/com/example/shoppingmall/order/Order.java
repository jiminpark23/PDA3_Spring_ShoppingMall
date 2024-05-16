package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {
    private int id;
    // private int productId;  // 사용자가 보는 화면과 DB에 저장되는 정보는 다를 수 있음
                            // Domain이 곧 객체Object (DDD스럽게)
    Product product;
    private int count;
    // DB column : Orders
    // orders_id or id (선택 차이 but "통일성" 있게)

    // 생성자
    public Order(Product orderedProduct, int count) {
        this.product = orderedProduct;
        this.count = count;
    }
}
