//package com.example.shoppingmall.utils;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//
//@Getter
//@AllArgsConstructor
//public class ApiResult<T> {
//
//    public ApiResult<T> success(T data) {
//        return new ApiResult<>(true, data, null);
//    }
//
//    boolean success;
//    T response;
//    ApiError error;
//
//    @Getter
//    static class ApiError {
//        String message;
//        HttpStatus httpStatus;
//
//        public ApiError(String message, HttpStatus httpStatus) {
//            this.message = message;
//            this.httpStatus = httpStatus;
//        }
//    }
//
//}
//
