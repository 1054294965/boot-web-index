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

public class LoggerInterceptor  implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //创建请求实体
        LoggerEntity loggerEntity = new LoggerEntity();
        //获取请求的sessionId
        String sessionId = request.getRequestedSessionId();
        //请求的路径
        String path = request.getRequestURI();
        //获取请求参数信息
//        String paramData = JSON.toJSONString(request.getParameterMap(),SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue);
        //设置客户端ip
//        loggerEntity.setIp(LoggerUtils.getCliectIp(request));
        //设置请求方法
        loggerEntity.setMethod(request.getMethod());
        //设置请求类型
//        loggerEntity.setType(LoggerUtils.getRequestType(request));
        //设置请求参数的json字符串
//        loggerEntity.setParamData(paramData);
        //设置请求地址
        loggerEntity.setUri(path);
        //设置sessionId
        loggerEntity.setSessionId(sessionId);
        System.out.println(JSON.toJSON(loggerEntity));
        //设置请求开始时间
//        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
//        //设置请求实体到request中，方便after调用
//        request.setAttribute(LOGGER_ENTITY,loggerEntity);
        return true;


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {

    }

}
