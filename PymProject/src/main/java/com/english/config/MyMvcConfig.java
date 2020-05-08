package com.english.config;

import com.english.component.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;

//
@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport{
//    @Autowired
//    GlobalInterceptor globalInterceptor;
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/english").setViewName("/home/english");
//        registry.addViewController("/*").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/admin").setViewName("/admin/table");
        registry.addViewController("/test").setViewName("/test");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有C:/Users/gzpost05/Desktop/springboot博客/ 访问都映射到/myTest/** 路径下
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(globalInterceptor).addPathPatterns("/*");
//    }
}
