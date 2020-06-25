package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyListener implements ServletRequestListener {
    private static Logger logger = LoggerFactory.getLogger(MyListener.class);
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest servletRequest =(HttpServletRequest)sre.getServletRequest();
        String id = servletRequest.getSession().getId();
        logger.info("MyListener destroy....,id: {}",id);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest =(HttpServletRequest)sre.getServletRequest();
        String id = servletRequest.getSession().getId();
        logger.info("MyListener init....,id: {}",id);

    }
}
