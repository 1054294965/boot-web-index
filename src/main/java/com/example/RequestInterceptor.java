package com.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class RequestInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //把整个log中的参数，交给logUtil来获取，并返回log对象
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        RequestMapping methodAnnotation = handlerMethod.getMethodAnnotation(RequestMapping.class);
        RequestLoggerEntity entity = new RequestLoggerEntity();
        entity.setIp(request.getRemoteAddr()); // ip地址
        entity.setUri(request.getRequestURI());
        entity.setRequestName(methodAnnotation.name());
//        entity.setType(request.getMethod());
        logger.info(JSON.toJSONString(entity));

        if(1==1){
            // 这两行编码格式的代码需要设置  否则中文乱码
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");

            PrintWriter out = null ;
            JSONObject res = new JSONObject();

            res.put("code",-1);
            res.put("message","未知异常");
            out = response.getWriter();
            out.append(res.toString());
            return false;
        }

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

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        RequestMapping methodAnnotation = handlerMethod.getMethodAnnotation(RequestMapping.class);

        String name = methodAnnotation.name();
        entity.setUri(request.getRequestURI());
        entity.setRequestName(methodAnnotation.name());
        entity.setMethod(request.getMethod());
        logger.info(JSON.toJSONString(entity));
        logger.info( handlerMethod.getMethod().getName());

    }


}
