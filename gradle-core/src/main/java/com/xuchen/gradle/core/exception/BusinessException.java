package com.xuchen.gradle.core.exception;

import lombok.Data;

/**
 * @author Edwin
 * @date 2019/9/5
 */
@Data
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
