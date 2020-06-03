package com.xuchen.gradle.api.controller;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xuchen.gradle.core.core.jwt.JwtService;
import com.xuchen.gradle.core.model.R;
import com.xuchen.gradle.core.mysql.user.entity.User;
import com.xuchen.gradle.core.mysql.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    JwtService jwtService;

    @GetMapping("login")
    public R hello(@Valid User user, BindingResult bindingResult) {
        User dbUser = userService.getOne(new QueryWrapper<>(user));
        if (dbUser == null){
            return R.fail("用户不存在");
        }
        if (!SecureUtil.md5(user.getPassword()).equals(dbUser.getPassword())){
            return R.fail("密码不正确");
        }
        return R.success(jwtService.generateToken(dbUser));
    }
}
