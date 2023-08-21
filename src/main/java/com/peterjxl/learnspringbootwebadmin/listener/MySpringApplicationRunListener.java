package com.peterjxl.learnspringbootwebadmin.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;



public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication application;

    // 必须有的构造器
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
    }

    @Override
    public void starting() {
        // SpringApplication.run()方法执行之前执行的代码
        System.out.println("MySpringApplicationRunListener...starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        // 获取到环境变量
        System.out.println("MySpringApplicationRunListener...environmentPrepared...");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        // IoC容器已经创建完成，但是没有加载bean
        System.out.println("MySpringApplicationRunListener...contextPrepared...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        // IoC容器已经创建完成，bean也已经加载完成
        System.out.println("MySpringApplicationRunListener...contextLoaded...");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        // SpringApplication.run()方法执行之后执行的代码
        System.out.println("MySpringApplicationRunListener...started...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        // 应用正在运行
        System.out.println("MySpringApplicationRunListener...running...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        // 应用启动失败
        System.out.println("MySpringApplicationRunListener...failed...");
    }
}

