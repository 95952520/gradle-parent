package com.xuchen.gradle.core.rocket.consumer;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "myTopic", selectorExpression = "myTags", consumerGroup = "consumerTagGroup")
public class ConsumerTagsService implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.warn(StrUtil.format("接受到消息msg[{}]", message));
    }
}
