package com.example;

import com.alibaba.fastjson.JSONObject;
import io.micrometer.core.instrument.util.StringUtils;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ApiFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request; // 这里转化下，否则Servlet是无法获取到url呢
        HttpServletResponse httpServletResponse = (HttpServletResponse)response; // 这里转化下，否则Servlet是无法获取到url呢
        String URL = httpServletRequest.getRequestURL().toString();
        if(URL.contains("api")){ // 如果包含api，说明是对外接口 那么不过滤
            chain.doFilter(request,response);

        }else{
            if(1!=1){ // 这里模拟用户登录
                httpServletResponse.sendRedirect("/login"); // 重定向到登录页面
            }else{
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

                }

            }

        }

    }

    @Override
    public void destroy() {

    }

}
