package com.example.shoppingmall.member;

import org.springframework.http.HttpStatus;

public class ApiResult<T> {
    private boolean success;
    private T response;
    private ApiError error;

    public static class ApiSuccess {


    }



}

class ApiError {
    String message;
    HttpStatus httpStatus;

}