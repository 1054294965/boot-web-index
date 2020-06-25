package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MySessionListener implements HttpSessionListener {
    private static Logger logger = LoggerFactory.getLogger(MySessionListener.class);
    public MySessionListener(){
        System.out.println("MySessionListener init:");
    }
    public void sessionCreated(HttpSessionEvent se) {

        logger.info("MySessionListener create,id: {}",se.getSession().getId());

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("MySessionListener destroyed,id: {}",se.getSession().getId());
    }

}
