package com.xuchen.gradle.api.service;

import com.xuchen.gradle.core.core.jwt.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuchen
 * @date 2019/08/09
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@Slf4j
public class ServiceTest {

    @Autowired
    JwtService jwtService;

    @Test
    public void service() {

    }
}
