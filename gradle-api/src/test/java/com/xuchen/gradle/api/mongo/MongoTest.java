package com.xuchen.gradle.api.mongo;

import com.xuchen.gradle.core.mongo.dao.MUserDao;
import com.xuchen.gradle.core.mongo.entity.MUser;
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
@SpringBootTest
@Slf4j
public class MongoTest {

    @Autowired
    MUserDao mUserDao;

    @Test
    public void service() {

    }
}
