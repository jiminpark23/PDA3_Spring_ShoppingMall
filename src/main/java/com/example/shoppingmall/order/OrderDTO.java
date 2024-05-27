package com.example.shoppingmall.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private int id;

    @JsonProperty("product_id")
    @NotBlank(message = "상품 아이디를 입력해주세요.")
    private int productId;
    @NotBlank(message = "수량을 입력해주세요.")
    @Size(min=1, max=2, message = "99개 이하로 설정해주세요.")
    private int count;

    public Order convertToEntity(OrderService orderService) {
        return orderService.convertToEntity(this);
    }
}
