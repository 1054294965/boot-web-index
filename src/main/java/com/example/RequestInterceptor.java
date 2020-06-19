package com.example;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //把整个log中的参数，交给logUtil来获取，并返回log对象
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        RequestMapping methodAnnotation = handlerMethod.getMethodAnnotation(RequestMapping.class);
        String name = methodAnnotation.name();
        RequestLoggerEntity entity = new RequestLoggerEntity();

        String requestURI = request.getRequestURI();
//        logger.info("请求名：{}",name);
//        logger.info("path：{}",methodAnnotation.path());
//        logger.info("path：{}",methodAnnotation.method());
//        logger.info("requestURI：{}",requestURI);
//        logger.info("getRequestURI：{}",request.getRequestURI());
        entity.setIp(request.getRemoteAddr());
        entity.setUri(request.getRequestURI());
        entity.setRequestName(methodAnnotation.name());
        entity.setType(request.getMethod());
        logger.info(JSON.toJSONString(entity));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
//        logger.info(JSON.toJSONString(handler));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        RequestLoggerEntity entity = new RequestLoggerEntity();
        String requestURI = request.getRequestURI();
//        logger.info("请求名：{}",name);
//        logger.info("path：{}",methodAnnotation.path());
//        logger.info("path：{}",methodAnnotation.method());
//        logger.info("requestURI：{}",requestURI);
//        logger.info("getRequestURI：{}",request.getRequestURI());
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        RequestMapping methodAnnotation = handlerMethod.getMethodAnnotation(RequestMapping.class);

        String name = methodAnnotation.name();
        entity.setUri(request.getRequestURI());
        entity.setRequestName(methodAnnotation.name());
        entity.setType(request.getMethod());
        logger.info(JSON.toJSONString(entity));

    }


}
