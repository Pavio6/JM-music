package com.jlf.music.custom.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalTimeConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * JavaTimeModule 提供了自定义的序列化和反序列化功能
         * 使得 Jackson 能够正确处理 Java 8 日期和时间类
         * 这意味着可以将这些对象序列化为 JSON 字符串并将 JSON 字符串反序列化为相应的 Java 对象
         */
        objectMapper.registerModule(new JavaTimeModule()); // 注册 JavaTimeModule
        return objectMapper;
    }
}
