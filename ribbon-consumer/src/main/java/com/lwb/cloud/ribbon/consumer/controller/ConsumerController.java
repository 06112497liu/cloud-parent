package com.lwb.cloud.ribbon.consumer.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuweibo
 * @date 2019/7/4
 */
@RestController
@RequestMapping("/consumer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsumerController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        ResponseEntity<String> forEntity = this.restTemplate.getForEntity(
            "http://hello-service/hello/service/test", String.class
        );
        return forEntity.getBody();

    }

}
