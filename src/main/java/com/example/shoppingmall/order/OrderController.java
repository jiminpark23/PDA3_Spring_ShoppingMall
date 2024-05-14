package com.example.shoppingmall.order;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    // test
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
