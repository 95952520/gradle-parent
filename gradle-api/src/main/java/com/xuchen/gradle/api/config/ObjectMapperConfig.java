//package com.xuchen.gradle.api.config;
//
//import cn.hutool.core.date.DatePattern;
//import cn.hutool.core.date.DateUtil;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//
///**
// * @author Edwin
// * @date 2020/4/9
// */
//@Configuration
//public class ObjectMapperConfig {
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        SimpleModule javaTimeModule = new JavaTimeModule()
//                .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer())
//                .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
//        return new ObjectMapper()
//                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
//                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
//                .registerModule(javaTimeModule)
//                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
//    }
//
//    public static class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
//        @Override
//        public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeNumber(DateUtil.format(localDateTime, DatePattern.NORM_DATETIME_PATTERN));
//        }
//    }
//
//    public static class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
//        @Override
//        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//            return DateUtil.parseLocalDateTime(jsonParser.getValueAsString(), DatePattern.NORM_DATETIME_PATTERN);
//        }
//    }
//
//}
