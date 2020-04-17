package com.xuchen.gradle.core.core.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Edwin
 * @date 2020/4/13
 */
@Slf4j
@Service
public class Async2Service {

    @Autowired
    Async1Service async1Service;

    public void method1(){
        log.info("async2---------method1");
        method2();
        async1Service.method1();
    }
    @Async
    public void method2(){
        log.info("async2---------method2");
        async1Service.method2();
    }
    @Async
    public void method3(){
        log.info("async2---------method3");
        async1Service.method3();
    }
    @Async
    public void method4(){
        log.info("async2---------method3");
        async1Service.method2();
    }
}
