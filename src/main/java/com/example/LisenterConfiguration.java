package com.example;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LisenterConfiguration {
    @Bean
    public ServletListenerRegistrationBean getListenerBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        MyListener myListener = new MyListener();
        MySessionListener mySessionListener= new MySessionListener();
        bean.setListener(myListener);
        bean.setListener(mySessionListener);
        return bean;
    }

}
