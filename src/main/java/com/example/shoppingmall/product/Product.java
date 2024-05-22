package com.example.shoppingmall.product;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private int id;
    private int categoryId;
    private String name;
    private int price;
    private String description;

    public Product(int categoryId, String name, int price, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // getter, setter
    // setter는 가능한 도메인 객체에는 만들면 안된다.
    // TODO: setter는 DTO 등장하고 지우러 오자!

}
