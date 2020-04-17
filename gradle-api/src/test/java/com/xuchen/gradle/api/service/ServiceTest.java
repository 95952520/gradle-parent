package com.xuchen.gradle.api.service;

import cn.hutool.extra.spring.SpringUtil;
import com.xuchen.gradle.core.core.jwt.JwtService;
import com.xuchen.gradle.core.mysql.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xuchen
 * @date 2019/08/09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ServiceTest {

    @Test
    public void service() {
        JwtService service = SpringUtil.getBean(JwtService.class);
//        String generateToken = service.generateToken(new User() {{
//            setId(99);
//            setNickName("myNickName");
//        }});
//        System.out.println(generateToken);
        User user = service.parseToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJncmFkbGVTdWJqZWN0Iiwibmlja05hbWUiOiJteU5pY2tOYW1lIiwiaXNzIjoiZ3JhZGxlU2VydmVyIiwiaWQiOjk5LCJleHAiOjE1ODcxMjMwNTksImlhdCI6MTU4NzExNTg1OX0.vx1cVD65w0e2gzFtXjoOqYsS-7gm_iFYuQcGPKIeQUk");
    }
}
