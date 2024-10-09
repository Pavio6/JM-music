package com.jlf.music.custom.config;

import com.jlf.music.custom.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(this.authenticationInterceptor)
                .addPathPatterns("/admin/**") // 拦截路径
                .excludePathPatterns("/admin/login/**"); // 排除要拦截的路径
    }
}
