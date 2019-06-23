package com.lwb.cloud.client1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuweibo
 * @date 2019/6/22
 */
@RestController
@RequestMapping("/client1")
public class Clinet1Controller {


    @GetMapping("/hello")
    public String hello() {
        return "clent1";
    }
}
