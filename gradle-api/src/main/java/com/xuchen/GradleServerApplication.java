package com.xuchen;

import cn.hutool.extra.spring.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.xuchen.gradle.core.mysql.user.dao")
@EnableAsync
@Import(SpringUtil.class)
public class GradleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleServerApplication.class, args);
    }

}
