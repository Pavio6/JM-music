package com.jlf.music.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

public class CustomDateSerializer extends com.fasterxml.jackson.databind.JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // 格式化为 "yyyy-MM-dd HH:mm:ss" 形式
        String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        jsonGenerator.writeString(formattedDate);
    }
}
