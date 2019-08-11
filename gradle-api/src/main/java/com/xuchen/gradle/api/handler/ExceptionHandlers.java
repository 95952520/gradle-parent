package com.xuchen.gradle.api.handler;

import com.xuchen.gradle.core.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R throwable(Exception e) {
        log.error("拦截异常", e);
        return R.fail();
    }
}
