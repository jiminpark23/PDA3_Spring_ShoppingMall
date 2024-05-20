package com.example.shoppingmall.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiUtils {
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, data, null);
    }

    public static <M> ApiResult<M> error(M message, HttpStatus httpStatus) {
        return new ApiResult(false,
                null,
                new ApiError(message, httpStatus));
    }

    public static <T> ApiResult<T> error(String message, HttpStatus status, List<ObjectError> errors) {
        StringBuilder errorMessage = new StringBuilder(message);
        for (ObjectError error : errors) {
            errorMessage.append(": ").append(error.getDefaultMessage());
        }
        return new ApiResult<>(false, null, new ApiError(errorMessage.toString(), status));
    }

    @Getter
    @AllArgsConstructor
    public static class ApiResult<T> {

        boolean success;
        T response;
        ApiError error;
    }

    @Getter
    static class ApiError<M> {
        M message;
        HttpStatus httpStatus;

        ApiError(M message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
        }
    }
}
