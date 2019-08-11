package com.xuchen.gradle.api.service;

import com.xuchen.gradle.core.entity.User;
import com.xuchen.gradle.core.service.UserService;
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
@SpringBootTest
public class ServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void service() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setNickName("nickName" + i);
            user.setPassword("password" + i);
            userService.save(user);
        }
    }
}
