package com.xuchen.gradle.api.service;

import cn.hutool.json.JSONUtil;
import com.xuchen.gradle.core.entity.User;
import com.xuchen.gradle.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author xuchen
 * @date 2019/08/09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void service() {
        List<User> list = userService.list();
        log.info(JSONUtil.toJsonPrettyStr(list));
    }
}
