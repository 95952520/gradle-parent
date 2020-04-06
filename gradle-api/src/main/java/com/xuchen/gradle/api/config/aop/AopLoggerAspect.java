package com.xuchen.gradle.api.config.aop;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
@Slf4j
@Profile({"local", "dev"})
public class AopLoggerAspect {

    @Pointcut("execution(* com.xuchen.gradle.api.controller..*.*(..))")
    public void controllerPointCut() {

    }

    @Around("controllerPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if ("get".equalsIgnoreCase(request.getMethod())) {
            log.info("Get请求[{}]入参:[{}]", request.getRequestURI(), getJsonParams(request.getParameterMap()));
        } else {
            log.info("Post请求[{}]入参:[{}]", request.getRequestURI(), JSONUtil.toJsonStr(joinPoint.getArgs()[0]));
        }
        long millis = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        log.info("耗时：[{}ms]", System.currentTimeMillis() - millis);
        log.info("返回：[{}]", JSONUtil.toJsonStr(result));
        return result;
    }


    private static String getJsonParams(Map<String, String[]> map) {
        Map<String, String> paramsMap = new HashMap<>();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            paramsMap.put(entry.getKey(), entry.getValue()[0]);
        }
        return JSONUtil.toJsonStr(paramsMap);
    }
}
