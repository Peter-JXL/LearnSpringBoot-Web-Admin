package com.peterjxl.learnspringbootwebadmin.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class AppInfo implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("author", "peterjxl")
                .withDetail("email", "peterjxl@qq.com")
                .withDetails(Collections.singletonMap("version", "1.0.0")); // 可以传入map
    }
}
