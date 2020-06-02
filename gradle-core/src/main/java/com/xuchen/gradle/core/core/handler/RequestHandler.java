package com.xuchen.gradle.core.core.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.xuchen.gradle.core.core.bean.RequestContextBean;
import com.xuchen.gradle.core.core.jwt.JwtService;
import com.xuchen.gradle.core.mysql.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Edwin
 * @date 2020/6/2
 */
@Slf4j
public class RequestHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        RequestContextBean requestContextBean = SpringUtil.getBean(RequestContextBean.class);
        JwtService jwtService = SpringUtil.getBean(JwtService.class);
        String token = request.getHeader("Authorization");
        if (StrUtil.isBlank(token)){
            log.warn("请求头里不含token");
        }
        log.info("请求头里拿到token：{}",token);
        User user = jwtService.parseToken(token);
        requestContextBean.setUser(user);
        return true;
    }
}
