package com.lwb.cloud.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 * @author liuweibo
 * @date 2019/6/10
 */
@SpringBootApplication
public class CloudClient1Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudClient1Application.class, args);
    }
}
