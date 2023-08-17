package com.peterjxl.learnspringbootwebadmin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class MyComponentIndicator extends AbstractHealthIndicator {

    /**
     * 实现具体的检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 使用builder 来创建健康状态信息

        Map<String, Object> map = new HashMap<>();
        if (1==1) {
            //builder.up();
            builder.status(Status.UP);
            map.put("count", 1); //自定义监控内容，key-value形式，例如：当前数据库连接数
            map.put("ms", 100); // 时间
        }else {
            builder.status(Status.OUT_OF_SERVICE);
            map.put("error", "连接超时");
            map.put("ms", 3000); // 时间
        }

        builder.withDetail("code", 1) // 可以传入错误信息
                .withDetails(map);   // 还可以传入map，可以传入更多检查信息
    }
}
