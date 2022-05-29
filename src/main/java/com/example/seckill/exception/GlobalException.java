package com.example.seckill.exception;

import io.swagger.models.auth.In;

public class GlobalException extends RuntimeException{

    Integer code;

    public GlobalException( String message, Integer code) {
        super(message);
        this.code = code;
    }
}
