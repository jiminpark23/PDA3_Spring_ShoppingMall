package com.example.shoppingmall.exception;

public class DuplicateMemberIdException extends Exception {
    private String message;

    public DuplicateMemberIdException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
