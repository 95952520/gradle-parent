package com.xuchen.gradle.core.rocket.consumer;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.xuchen.gradle.core.mysql.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "myTopic", selectorExpression = "myTags", consumerGroup = "consumerUserGroup")
public class ConsumerUserService implements RocketMQListener<User> {

    @Override
    public void onMessage(User user) {
        log.warn(StrUtil.format("[User]接受到消息msg[{}]", JSONUtil.toJsonStr(user)));
    }
}
