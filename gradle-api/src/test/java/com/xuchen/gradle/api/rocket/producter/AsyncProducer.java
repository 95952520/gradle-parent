package com.xuchen.gradle.api.rocket.producter;

import cn.hutool.core.util.StrUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.time.LocalDateTime;

/**
 * 发送异步消息
 */
@Slf4j
public class AsyncProducer {
    @SneakyThrows
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("groupAsync");
        producer.setNamesrvAddr("localhost:9876");
        producer.setRetryTimesWhenSendAsyncFailed(0);
        producer.start();
        Message message = new Message("baseTopic", "tagAsync", StrUtil.bytes("message-async-" + LocalDateTime.now()));
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("发送成功");
                log.info(sendResult.toString());
            }
            @Override
            public void onException(Throwable e) {
                log.error("异步消息发送失败", e);
            }
        });
        Thread.sleep(1000);
        producer.shutdown();
    }
}
