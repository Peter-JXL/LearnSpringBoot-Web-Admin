package com.peterjxl.learnspringbootwebadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LearnSpringBootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootWebAdminApplication.class, args);
    }

}
