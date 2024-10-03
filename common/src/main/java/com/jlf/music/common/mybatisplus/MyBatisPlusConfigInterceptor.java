package com.jlf.music.common.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfigInterceptor {
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        // 创建分页插件 设定数据库类型为MYSQL
        return new PaginationInnerInterceptor(DbType.MYSQL);
    }
}
