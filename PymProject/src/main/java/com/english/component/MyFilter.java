package com.english.component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String url = request.getServletPath();
        String[] a = url.split("/");
//        request.getRequestDispatcher("index").forward(servletRequest,servletResponse);
//        System.out.println(url+"-------"+request.getContextPath()+"/select/"+a[a.length-1]);
// filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
