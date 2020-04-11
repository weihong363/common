package com.ironion.demo.controller;

import com.ironion.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author huangwc
 * @date 2020/4/11 4:46 下午
 */
@SpringBootTest
@Slf4j
class TestControllerTest {

    //测试controller需要用到MockeMvc
    private MockMvc mvc;

    @Mock
    private TestService service;

    @InjectMocks
    private TestController controller;

    @BeforeEach
    void setUp() {

        //执行后，自动将service注入到controller
        MockitoAnnotations.initMocks(this);

        //1.构建mvc环境
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectOne() throws Exception {
        // (2)模拟外部依赖返回结果(这个类返回一个实体)
//        when(service.queryById(Mockito.any(Integer.class))).thenReturn(new com.ironion.demo.entity.Test());

        // (2)构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/user/1")
                .contentType("text/html")
                .accept(MediaType.APPLICATION_JSON);

        // (3)发送请求，获取请求结果
        ResultActions perform = mvc.perform(request);

        // (4)请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        // (5)校验返回信息
        log.info(response.getContentAsString());
    }

    @Test
    void save() throws Exception {
        // (2)模拟外部依赖返回结果(这个类返回一个实体)
//        when(service.queryById(Mockito.any(Integer.class))).thenReturn(null);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","张三");
        // (2)构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user")
                //带上token
//                .header("Authorization",token)
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonObject.toJSONString());

        // (3)发送请求，获取请求结果
        ResultActions perform = mvc.perform(request);

        // (4)请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isCreated());

        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        // (5)校验返回信息
        log.info(response.getContentAsString());
    }

    @Test
    void update() throws Exception {
        // (2)模拟外部依赖返回结果(这个类返回一个实体)
//        when(service.queryById(Mockito.any(Integer.class))).thenReturn(null);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("name","王五");
        // (2)构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/user")
                //带上token
//                .header("Authorization",token)
                .contentType("application/json")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonObject.toJSONString());

        // (3)发送请求，获取请求结果
        ResultActions perform = mvc.perform(request);

        // (4)请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isNoContent());

        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        // (5)校验返回信息
        log.info(response.getContentAsString());
    }

    @Test
    void remove() throws Exception {
        // (2)模拟外部依赖返回结果(这个类返回一个实体)
//        when(service.queryById(Mockito.any(Integer.class))).thenReturn(null);
        // (2)构建请求
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/user/1")
                //带上token
//                .header("Authorization",token)
                .contentType("text/html")
                .accept(MediaType.APPLICATION_JSON);

        // (3)发送请求，获取请求结果
        ResultActions perform = mvc.perform(request);

        // (4)请求结果校验
        perform.andExpect(MockMvcResultMatchers.status().isNoContent());

        MvcResult mvcResult = perform.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        // (5)校验返回信息
        log.info(response.getContentAsString());
    }
}
