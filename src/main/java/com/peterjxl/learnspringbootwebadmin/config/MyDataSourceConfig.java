package com.peterjxl.learnspringbootwebadmin.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

//@Configuration
public class MyDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 配置Druid的监控
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        return servletRegistrationBean;
    }
    
    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.css,/druid/*");
        return filterFilterRegistrationBean;
    }

}
