package com.xuchen.gradle.api.rocket.producter;

import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.time.LocalDateTime;

/**
 * 发送单项消息
 */
@Slf4j
public class OneWayProducer {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("groupSync");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        Message message = new Message("baseTopic","tagOneWay", StrUtil.bytes("message-oneWay-"+ LocalDateTime.now()));
        producer.sendOneway(message);
        producer.shutdown();
    }
}
