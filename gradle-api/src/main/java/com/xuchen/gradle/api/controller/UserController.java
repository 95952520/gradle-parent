package com.xuchen.gradle.api.controller;


import com.xuchen.gradle.api.controller.base.BaseController;
import com.xuchen.gradle.core.base.entity.User;
import com.xuchen.gradle.core.base.model.R;
import com.xuchen.gradle.core.base.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器</p>
 *
 * @author xuchen
 * @since 2019-08-07
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @GetMapping("get")
    public R get(User user) {
        user = userService.getById(user);
        log.info(user.toString());
        return R.success(user);
    }

}
