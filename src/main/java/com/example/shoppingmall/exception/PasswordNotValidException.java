package com.example.shoppingmall.exception;

public class PasswordNotValidException extends RuntimeException {
    private String message;

    public PasswordNotValidException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
