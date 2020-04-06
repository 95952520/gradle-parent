package com.xuchen.gradle.core.rocket.consumer;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "myTopic", consumerGroup = "consumerGroup")
public class ConsumerService implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        log.warn(StrUtil.format("接受到消息主题[{}],tags[{}],msg[{}]", message.getTopic(), message.getTags(), StrUtil.str(message.getBody(), CharsetUtil.UTF_8)));
    }
}
