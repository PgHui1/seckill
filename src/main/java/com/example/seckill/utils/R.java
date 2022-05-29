package com.example.seckill.utils;

import java.util.Map;

/**
 * 通用返回对象
 */
public class R {

    private String message;
    private Integer code;
    private Map<String,Object> data;

    public static R ok(){
        return new R();
    }

    public static R fail(){
        return new R();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R data(Map<String,Object> data){
        this.setData(data);
        return this;
    }

}
