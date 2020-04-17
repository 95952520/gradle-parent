package com.xuchen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.xuchen", "cn.hutool.extra.spring"})
@MapperScan("com.xuchen.gradle.core.mysql.user.dao")
@EnableAsync
public class GradleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleServerApplication.class, args);
    }

}
