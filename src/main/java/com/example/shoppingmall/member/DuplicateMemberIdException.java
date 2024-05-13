package com.example.shoppingmall.member;

public class DuplicateMemberIdException extends Exception {
    private String message;

    DuplicateMemberIdException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
