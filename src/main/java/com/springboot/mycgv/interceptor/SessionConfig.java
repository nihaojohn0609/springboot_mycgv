package com.springboot.mycgv.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SessionConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration sessionCheckInterceptor = registry.addInterceptor(new SessionAuthInterceptor()); // 문지기 역할 하는 객체 추가
        sessionCheckInterceptor.addPathPatterns("/mypage**/**", "/admin**/**");    // 더 추가하려면 ','로 구분해서 추가하기
        //sessionCheckInterceptor.excludePathPatterns();
    }
}
