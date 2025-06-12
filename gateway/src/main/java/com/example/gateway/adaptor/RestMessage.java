package com.example.gateway.adaptor;

/**
 * Generic wrapper for REST responses.
 */
public class RestMessage<T> {
    private boolean success;
    private String message;
    private T data;

    public RestMessage() {
    }

    public RestMessage(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> RestMessage<T> ok(T data) {
        return new RestMessage<>(true, null, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
}
