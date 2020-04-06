package com.xuchen.gradle.api.rocket.consumer;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.nio.charset.Charset;

/**
 * 消息消费者-不同模式
 */
@Slf4j
public class ConsumerModel {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("groupSync");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.subscribe("baseTopic", "tagSync");
        //广播
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        //负载均衡
        consumer.setMessageModel(MessageModel.CLUSTERING);
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            log.info(JSONUtil.toJsonStr(msgs));
            byte[] body = msgs.get(0).getBody();
            log.info(StrUtil.str(body, Charset.defaultCharset()));
            log.info(JSONUtil.toJsonStr(context));
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
    }
}
