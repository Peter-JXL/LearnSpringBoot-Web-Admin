package com.peterjxl.learnspringbootwebadmin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class MyRegistrationCOnfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        // 第一个参数是Servlet，第二个参数是Servlet要过滤的路径，可以传多个
        return new ServletRegistrationBean(new MyServlet(), "/my", "/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        // 第一个参数是过滤器，第二个参数是过滤器要过滤的路径，也可以传一个ServletRegistrationBean对象，过滤器就会过滤这个ServletRegistrationBean对象中的路径
        return new FilterRegistrationBean(new MyFilter(), myServlet());
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        return new ServletListenerRegistrationBean(new MyServletContextListener());
    }
}
