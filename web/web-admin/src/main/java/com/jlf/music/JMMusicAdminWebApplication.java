package com.jlf.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.jlf.music.mapper")
public class JMMusicAdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(JMMusicAdminWebApplication.class, args);
    }
}

