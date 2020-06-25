package com.example;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login/**");
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new ApiFilter());
        frBean.addUrlPatterns("/*");
        System.out.println("filter");
        return frBean;
    }


}