package com.example.square.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@EnableAutoConfiguration
public class TestController {
    @Value("${square.owner}")
    private String owner;
    @Value("${square.email}")
    private String email;
//    @Value("${square}")
//    private Map<String, String> square;
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        System.out.println(email);
//        System.out.println(square);
        return owner;
    }
}
