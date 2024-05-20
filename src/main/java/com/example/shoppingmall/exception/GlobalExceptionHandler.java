package com.example.shoppingmall.exception;

import com.example.shoppingmall.utils.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;

@Slf4j
@RestControllerAdvice // 전역 예외 처리
public class GlobalExceptionHandler {
    // 유효성 검사하다가 에러가 터지면 호출되는 예외 처리 메소드
    @ExceptionHandler//(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException errors) {

        Map<String, String> errorMessages = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String errorField = error.getField(); // 예외 field명
            String errorMessage = error.getDefaultMessage(); // 예외 message
            errorMessages.put(errorField, errorMessage);
        }

        log.info("errorMessage = {}", errorMessages);

        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }
}