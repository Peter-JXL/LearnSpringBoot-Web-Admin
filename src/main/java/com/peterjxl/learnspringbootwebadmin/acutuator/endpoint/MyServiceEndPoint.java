package com.peterjxl.learnspringbootwebadmin.acutuator.endpoint;


import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myService")
public class MyServiceEndPoint {

    @ReadOperation
    public Map getDockerInfo(){
        // 端点的读操作
        return Collections.singletonMap("dockerInfo", "docker is running");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("docker is stopped....");
    }

}
