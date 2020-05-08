package com.english.component;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String c=sce.getServletContext().getContextPath();
        sce.getServletContext().setAttribute("_ph", c);
        System.out.println("服务器启动成功"+"-----"+c);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("服务器关闭成功");
    }
}
