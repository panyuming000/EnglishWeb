package com.english.config;

import com.english.component.MyListener;
import com.english.component.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class MyServletConfig {

//    @Bean
//    public HttpSessionListener listener(){
//        return new MyListener();
//    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
//        String c = request.getContextPath();
//        request.setAttribute("-ph",c);
//        System.out.println("输出contextpath"+c);
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());

        return registrationBean;
    }
//    @Bean
//    public FilterRegistrationBean myFilter(){
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new MyFilter());
//        registrationBean.setUrlPatterns(Collections.singleton("/*"));
//        registrationBean.setName("/opt/");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
}
