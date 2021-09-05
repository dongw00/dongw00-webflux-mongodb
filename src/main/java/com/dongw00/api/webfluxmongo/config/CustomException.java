package com.dongw00.api.webfluxmongo.config;

public class CustomException extends RuntimeException {

    public CustomException(String type) {
        System.out.println(type + ": throw CustomException");
    }
}
