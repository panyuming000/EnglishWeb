package com.english.component;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
//@Component
public class GlobalInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletResponseWrapper httpResponse = new HttpServletResponseWrapper((HttpServletResponse) response);
        System.out.println(request.getRequestURI());
        String path = request.getRequestURI();
        if (true) {
            System.out.println(path);
            request.getRequestDispatcher("/opt/test1").forward(request,response);
        }
        return false;
    }
}
