package com.jlf.music.custom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().info(
                new Info()
                        .title("后台管理系统API")  // API标题
                        .version("1.0") // 版本
                        .description("音乐后台管理系统"));  // API描述
    }


    @Bean
    public GroupedOpenApi loginAPI() {

        return GroupedOpenApi.builder().group("后台登录管理").  // 设置API组的名称
                pathsToMatch( // 指定要包含在该组的路径
                "/admin/login/**",
                "/admin/info"
        ).
                build();
    }
    @Bean
    public GroupedOpenApi songManagementAPI() {

        return GroupedOpenApi.builder().group("后台音乐管理").  // 设置API组的名称
                pathsToMatch( // 指定要包含在该组的路径
                "/admin/singer/**",
                "/admin/song/**"
        ).
                build();
    }
    @Bean
    public GroupedOpenApi userManagementAPI() {

        return GroupedOpenApi.builder().group("后台用户管理").  // 设置API组的名称
                pathsToMatch( // 指定要包含在该组的路径
                "/admin/user/**"
        ).
                build();
    }
    @Bean
    public GroupedOpenApi playlistManagementAPI() {
        return GroupedOpenApi.builder().group("后台歌单管理").
                pathsToMatch(
                        "/admin/playlist/**"
                ).
                build();
    }
}
