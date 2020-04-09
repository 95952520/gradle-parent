package com.xuchen.gradle.api.controller;

import cn.hutool.core.lang.UUID;
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
    public R syncSend(String topic,String tags,String msg){
        User user = User.builder()
                .nickName(msg)
                .createTime(LocalDateTime.now())
                .id(RandomUtil.randomInt(100))
                .build();
        producerService.syncSendUser(topic, tags, user);
        return R.success();
    }

    @GetMapping("async")
    public R asyncSend(String topic,String tags,String msg){
        producerService.asyncSend(topic, tags, msg);
        return R.success();
    }

    @GetMapping("oneWay")
    public R oneWaySend(String topic,String tags,String msg){
        producerService.oneWaySend(topic, tags, msg);
        return R.success();
    }
}
