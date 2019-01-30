package com.xyj.learn.springmvc4;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author: xiayuejie
 * @date: 2019/1/8 13:57
 * @description:
 */
public class WebInitializer implements WebApplicationInitializer {//实现替代web.xml的位置

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MyMvcConfig.class);//注册配置类
        webApplicationContext.setServletContext(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));//注册DispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
