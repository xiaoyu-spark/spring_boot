package com.example.square.controller.restful;


import com.example.square.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.web.bind.annotation.*;

/**
 * @Controller ,@RestController ,RequestMapping
 * @PathVariable 路径参数,@ModelAttribute post表单参数,@RequestParam get请求参数
 *
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/restful")
public class RestfulTestController {
    @Value("${square.owner}")
    private String owner;
    @Value("${square.email}")
    private String email;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmail(@ModelAttribute User user) {
//        this.email = "";
        System.out.println(user.getName());
        return "success";
    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getEmail(@PathVariable String id) {
        System.out.println("path id--------------" + id);
        return this.email;
    }
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User getOwner(@RequestParam String id) {
        System.out.println("param id--------------" + id);
        System.out.println(this.owner);
        User user = new User();
        user.setAge(20);
        user.setName("测试大师");

        return user;
    }
}