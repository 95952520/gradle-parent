package com.xuchen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xuchen.gradle.core.mysql.user.dao")
public class GradleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleServerApplication.class, args);
    }

}
