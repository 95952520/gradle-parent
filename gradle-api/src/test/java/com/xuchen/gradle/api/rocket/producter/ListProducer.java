package com.xuchen.gradle.api.rocket.producter;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.time.LocalDateTime;

/**
 * 发送批量消息
 */
@Slf4j
public class ListProducer {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("groupSync");
        producer.setNamesrvAddr("localhost:9876");
        producer.setVipChannelEnabled(false);
        producer.start();
        Message message = new Message("baseTopic","tagSync", StrUtil.bytes("message-sync-"+ LocalDateTime.now()));
        Message message2 = new Message("baseTopic","tagSync", StrUtil.bytes("message-sync-"+ LocalDateTime.now()));
        SendResult result = producer.send(CollUtil.newArrayList(message,message2));
        log.info(result.toString());
        producer.shutdown();
    }
}
