package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

import static com.example.shoppingmall.utils.Validator.isNumber;

@RestController
@AllArgsConstructor  // 필드로 생성자 구현
public class ProductController {
    @Autowired  // DI - 생략 가능
    ProductService productService;

//    @AllArgsConstructor가 대신 해줌
//    ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    // 상품 개별 등록
    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {
        // 유효성 검사: name(영어), price(숫자)
        // 1) 조건문
        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {
            System.out.println("/products : controller - " + product.getName());
            Product savedProduct = productService.registerProduct(product);

            // TODO NPE 처리 (try-catch)
            try {
                System.out.println(savedProduct.getName());
            } catch (NullPointerException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 or 404(NOT_FOUND)
            }

            return new ResponseEntity<>(HttpStatus.CREATED);  // 201
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400
        }
    }

    // 상품 전체, 카테고리별 조회

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable int id) {
        // 1. Product 반환 필드 : id 넣어서 반환해야 함
        // 2. id 숫자만 들어오는 거 맞는지 유효성 검사 추가해야 함
        if (Validator.isNumber(id)) {
            System.out.println("id는 숫자다");
            return productService.findProduct(id);
        } else {
            // id가 숫자가 아닌 경우에는 유효하지 않음을 알림
            throw new IllegalArgumentException("유효하지 않은 id입니다.");
        }
    }
}
