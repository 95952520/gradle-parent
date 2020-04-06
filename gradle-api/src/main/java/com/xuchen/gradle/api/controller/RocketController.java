package com.xuchen.gradle.api.controller;

import com.xuchen.gradle.core.model.R;
import com.xuchen.gradle.core.rocket.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rocket")
public class RocketController {

    @Autowired
    ProducerService producerService;

    @GetMapping("sync")
    public R syncSend(String topic,String tags,String msg){
        producerService.syncSend(topic, tags, msg);
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
