package com.lwb.cloud.hello.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweibo
 * @date 2019/6/22
 */
@RestController
@RequestMapping("/hello/service")
public class HelloServiceController {


    @GetMapping("/test")
    public String test() {
        return "hello-service";
    }
}
