package com.example.square.controller;

import com.example.square.model.AutoConfig;
import io.swagger.annotations.ApiOperation;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@EnableAutoConfiguration
public class TestController {
    @Value("${square.owner}")
    private String owner;
    @Value("${square.email}")
    private String email;
//    @Value("${square.auto.config}")
//    private AutoConfig autoConfig;
//    private static String javaHome;
//    @Value("${square}")
//    private Map<String, String> square;
@ApiOperation(value="获取用户列表", notes="")
    @RequestMapping("/")
    @ResponseBody
    public String home() {

        return owner;
    }
}
