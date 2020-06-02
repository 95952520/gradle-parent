package com.xuchen.gradle.core.model.ex;

/**
 * @author Edwin
 * @date 2020/6/1
 */
public class BusiException extends RuntimeException {
    int code;

    public BusiException(String message) {
        super(message);
    }

    public BusiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
