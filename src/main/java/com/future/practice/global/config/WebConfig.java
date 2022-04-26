package com.future.practice.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionIntercept())
                .addPathPatterns("/**") //적용할 URL
                .excludePathPatterns("/login/**") // 제외할 URL (/login/하위로 오는 URL 제외)
                .excludePathPatterns("/v1/user/login")
                .excludePathPatterns("/v1/user/sign");


    }
}
