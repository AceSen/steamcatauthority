package com.steamcat.authority.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResultEntity
 * @Description TODO
 * @Author Administrator
 * @Data 下午 06:24
 * @Version 1.0
 **/
public class ResultEntity<T> {
    private boolean status;
    private String message;
    private T data;

    public ResultEntity() {
    }

    public ResultEntity(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResultEntity<T> success(T data) {
        return new ResultEntity<T>(true, "success", data);
    }

    public static <T> ResultEntity<T> fail(String errorCode, String errorMessage){
        Map<String, String> failMap = new HashMap<String, String>();
        failMap.put("errorCode", errorCode);
        failMap.put("errorMessage", errorMessage);
        return new ResultEntity(false, "fail", failMap);
    }
}
