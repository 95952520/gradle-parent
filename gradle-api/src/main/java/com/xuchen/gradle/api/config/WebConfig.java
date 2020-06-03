package com.xuchen.gradle.api.config;

import com.xuchen.gradle.core.core.handler.RequestHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Edwin
 * @date 2020/6/2
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestHandler())
                .addPathPatterns("/**")
                .excludePathPatterns("/hello","/login");
    }
}
