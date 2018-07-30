package com.example.square;


import com.example.square.controller.restful.RestfulTestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ControllerTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new RestfulTestController()).build();
    }
    @Test
    public void testRestfulController() throws Exception {
        RequestBuilder request = null;
        request = get("/api/restful/get")
                    .param("id","01");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("")));

        // 2、post提交一个user
        request = post("/api/restful/save/")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
        System.out.println("bbbbbbbbbbbbbb");

        // 3、get获取user列表，应该有刚才插入的数据
        request = get("/api/restful/get/01");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试大师\",\"age\":20}")));

        // 4、put修改id为1的user
//        request = put("/users/1")
//                .param("name", "测试终极大师")
//                .param("age", "30");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
//        request = get(request"/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        // 6、del删除id为1的user
//        request = delete("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
//        request = get("/users/");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("[]")));

    }
}
