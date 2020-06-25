package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
@ServletComponentScan
@SpringBootApplication
public class OaSpringBootApplication {
    private Logger logger = LoggerFactory.getLogger(OaSpringBootApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(OaSpringBootApplication.class, args);
    }



}
