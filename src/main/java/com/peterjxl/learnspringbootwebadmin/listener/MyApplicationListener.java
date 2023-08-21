package com.peterjxl.learnspringbootwebadmin.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // event包含了事件的信息，可以根据事件的类型进行不同的处理
        System.out.println("MyApplicationListener...onApplicationEvent..." + event);
    }
}
