package com.xuchen.gradle.api.service;

import com.xuchen.gradle.core.base.entity.User;
import com.xuchen.gradle.core.base.service.UserService;
import com.xuchen.gradle.core.second.entity.Person;
import com.xuchen.gradle.core.second.service.PersonService;
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
public class ServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;

    @Test
    public void service() {
        List<User> list = userService.list();
        System.out.println(list);
    }
}
