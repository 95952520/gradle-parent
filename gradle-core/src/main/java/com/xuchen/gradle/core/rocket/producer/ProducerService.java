package com.xuchen.gradle.core.rocket.producer;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xuchen.gradle.core.mysql.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ProducerService {

    @Autowired
    RocketMQTemplate rocketMQTemplate;
    @Value("${my.rocket.topic:myTopic}")
    String topic;
    @Value("${my.rocket.tags:myTags}")
    String tags;

    /**
     * 同步消息
     */
    public void syncSendUser(User user) {
        String destination = getDestination(topic, tags);
        log.info(StrUtil.format("给主题[{}]发同步消息[{}]", destination, JSONUtil.toJsonStr(user)));
        Message<User> message = MessageBuilder.withPayload(user).build();
        SendResult result = rocketMQTemplate.syncSend(destination, message);
        log.info(StrUtil.format("同步消息响应[{}]", JSONUtil.toJsonStr(result)));
    }

    /**
     * 异步消息
     */
    public void asyncSend(String msg) {
        String destination = getDestination(topic, tags);
        log.info(StrUtil.format("给主题[{}]发异步消息[{}]", destination, msg));
        Message<String> message = MessageBuilder.withPayload(msg).build();
        rocketMQTemplate.asyncSend(destination, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info(StrUtil.format("异步消息成功响应[{}]", JSONUtil.toJsonStr(sendResult)));
            }

            @Override
            public void onException(Throwable e) {
                log.error("异步消息失败", e);
            }
        });
    }

    /**
     * 单向消息
     */
    public void oneWaySend(String msg) {
        String destination = getDestination(topic, tags);
        log.info(StrUtil.format("给主题[{}]发异步消息[{}]", destination, msg));
        Message<String> message = MessageBuilder.withPayload(msg).build();
        rocketMQTemplate.sendOneWay(destination, message);
    }


    private String getDestination(String topic, String tags) {
        return topic + ":" + tags;
    }
}
