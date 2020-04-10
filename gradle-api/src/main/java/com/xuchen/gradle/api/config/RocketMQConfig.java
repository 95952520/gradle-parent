package com.xuchen.gradle.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.ByteArrayMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Edwin
 * @date 2020/4/10
 */
@Configuration
public class RocketMQConfig {

    @Bean
    public RocketMQMessageConverter rocketMQMessageConverter(ObjectMapper objectMapper){
        RocketMQMessageConverter converter = new RocketMQMessageConverter();
        List<MessageConverter> messageConverters = new ArrayList<>();
        ByteArrayMessageConverter byteArrayMessageConverter = new ByteArrayMessageConverter();
        byteArrayMessageConverter.setContentTypeResolver(null);
        messageConverters.add(byteArrayMessageConverter);
        messageConverters.add(new StringMessageConverter());
        MappingJackson2MessageConverter jackson2MessageConverter = new MappingJackson2MessageConverter();
        jackson2MessageConverter.setObjectMapper(objectMapper);
        messageConverters.add(jackson2MessageConverter);
        converter.resetMessageConverter(messageConverters);
        return converter;
    }
}
