package com.example.shoppingmall.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int id;

    @NotBlank(message = "카테고리 아이디를 입력해주세요.")
    @Pattern(regexp = "^[0-9_-]{1,2}", message = "카테고리 아이디는 1~2자리의 숫자여야 합니다.")
    @JsonProperty("category_id")
    private int categoryId;
    @NotBlank(message = "상품명을 입력해주세요.")
    private String name;
    @NotBlank(message = "가격을 입력해주세요.")
    private int price;
    @NotBlank(message = "상품에 대한 설명을 입력해주세요.")
    private String description;

    public Product convertToEntity() {
        return new Product(
                id,
                categoryId,
                name,
                price,
                description
        );
    }
}
