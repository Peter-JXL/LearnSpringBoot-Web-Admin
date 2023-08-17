package com.peterjxl.learnspringbootwebadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.peterjxl.learnspringbootwebadmin.mapper")
@ServletComponentScan
@SpringBootApplication()
public class LearnSpringBootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootWebAdminApplication.class, args);
    }

}
