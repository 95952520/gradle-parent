package com.xuchen.gradle.core.core.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Edwin
 * @date 2020/4/13
 */
@Slf4j
@Service
public class Async1Service {

    public void method1(){
        log.info("async1---------method1");
        method2();
    }
    @Async
    public void method2(){
        log.info("async1---------method2");
    }
    @Async
    public void method3(){
        log.info("async1---------method3");
        throw new RuntimeException("抛出异常");
    }
}
