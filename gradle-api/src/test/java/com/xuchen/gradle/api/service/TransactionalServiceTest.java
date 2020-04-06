package com.xuchen.gradle.api.service;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.xuchen.gradle.core.mysql.user.entity.User;
import com.xuchen.gradle.core.mysql.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * @author xuchen
 * @date 2019/08/09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserService userService;

    @Test
    public void service() {
        List<User> list = userService.list();
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.setHeaderAlias(new HashMap<String, String>(){{
            put("userName","姓名");
            put("password","密码");
        }});
        writer.write(list);
        writer.setDestFile(new File("F://1.xlsx"));
        writer.flush();
    }
}
