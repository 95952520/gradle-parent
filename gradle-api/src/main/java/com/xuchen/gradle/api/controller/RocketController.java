package com.xuchen.gradle.api.controller;

import cn.hutool.core.util.RandomUtil;
import com.xuchen.gradle.core.model.R;
import com.xuchen.gradle.core.mysql.user.entity.User;
import com.xuchen.gradle.core.rocket.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("rocket")
public class RocketController {

    @Autowired
    ProducerService producerService;

    @GetMapping("sync")
    public R syncSend(String msg) {
        User user = User.builder()
                .nickName(msg)
                .createTime(LocalDateTime.now())
                .id(RandomUtil.randomInt(100))
                .build();
        producerService.syncSendUser(user);
        return R.success(user);
    }

    @GetMapping("async")
    public R asyncSend(String msg) {
        producerService.asyncSend(msg);
        return R.success();
    }

    @GetMapping("oneWay")
    public R oneWaySend(String msg) {
        producerService.oneWaySend(msg);
        return R.success();
    }
}
