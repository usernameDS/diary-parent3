package com.kmu.manager.config;

import com.kmu.manager.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @作者：Deng 时间：2020/8/19 9:52
 */
@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
//        interceptorRegistration.addPathPatterns("/**").excludePathPatterns("/login.html","/login.do","/**/*.js", "/**/*.css","/**/*.woff*", "/**/*.ttf");

//    }
}
