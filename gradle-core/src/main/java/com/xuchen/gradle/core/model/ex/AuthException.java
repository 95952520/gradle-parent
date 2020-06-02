package com.xuchen.gradle.core.model.ex;

/**
 * @author Edwin
 * @date 2020/6/1
 */
public class AuthException extends RuntimeException {
    int code;

    public AuthException(int code,String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
