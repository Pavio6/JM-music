package com.jlf.music.custom.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class LocalTimeConfiguration {

    // 从配置文件中读取时间格式，默认为 "HH:mm:ss"
    @Value("${spring.jackson.time-format:HH:mm:ss}")
    private String pattern;

    // 定义一个 ObjectMapper Bean，用于自定义序列化和反序列化
    @Bean
    public ObjectMapper objectMapper() {
        // 创建一个 DateTimeFormatter 实例，根据配置的模式格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // 创建一个 SimpleModule，用于注册自定义的序列化和反序列化器
        SimpleModule module = new SimpleModule();
        // 添加 LocalTime 的序列化器，使用自定义的格式化器
        module.addSerializer(LocalTime.class, new LocalTimeSerializer(formatter));
        // 添加 LocalTime 的反序列化器，使用自定义的格式化器
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(formatter));

        // 创建 ObjectMapper 实例
        ObjectMapper mapper = new ObjectMapper();
        // 注册自定义模块，使其生效
        mapper.registerModule(module);

        // 返回配置好的 ObjectMapper 实例
        return mapper;
    }
}
