package com.xuchen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.xuchen.gradle.core.base.dao","com.xuchen.gradle.core.second.dao"})
public class GradleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleServerApplication.class, args);
    }

}
