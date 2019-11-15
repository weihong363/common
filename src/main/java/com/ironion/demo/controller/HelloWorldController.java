package com.ironion.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangwc
 * @date 2019/11/15 9:23 上午
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
