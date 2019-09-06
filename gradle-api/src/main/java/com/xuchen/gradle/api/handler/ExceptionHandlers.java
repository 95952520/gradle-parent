package com.xuchen.gradle.api.handler;

import com.xuchen.gradle.core.base.model.R;
import com.xuchen.gradle.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public R business(BusinessException e) {
        log.debug("拦截业务异常", e);
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exception(Exception e) {
        log.error("拦截异常", e);
        return R.fail();
    }
}
