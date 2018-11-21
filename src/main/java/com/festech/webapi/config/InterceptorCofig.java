package com.festech.webapi.config;

import com.festech.webapi.base.interceptors.ApiRequestTimeRecordInterceptor;
import com.festech.webapi.base.interceptors.ProcessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorCofig implements WebMvcConfigurer {

    @Bean
    public ApiRequestTimeRecordInterceptor apiRequestTimeRecordInterceptor() {

        return new ApiRequestTimeRecordInterceptor();
    }

    @Bean
    public ProcessInterceptor processInterceptor() {

        return new ProcessInterceptor();

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(apiRequestTimeRecordInterceptor()).addPathPatterns("/v*/**");

        registry.addInterceptor(processInterceptor()).addPathPatterns("/v*/**");

    }
}
