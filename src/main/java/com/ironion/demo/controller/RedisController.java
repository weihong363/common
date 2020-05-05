package com.ironion.demo.controller;

import com.ironion.demo.entity.UserEntity;
import com.ironion.demo.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: springbootdemo
 * @Date: 2019/1/25 15:03
 * @Author: Mr.Zheng
 * @Description:
 */
@Slf4j
@RequestMapping("/redis")
@RestController
public class RedisController {

    /**
     * redis中存储的过期时间60s
     */
    private static int ExpireTime = 60;

    @Resource
    private RedisUtils redisUtil;

    @PostMapping("/{key}/{value}")
    public boolean redisSet(@PathVariable String key, @PathVariable String value){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.valueOf(1));
        userEntity.setGuid(String.valueOf(1));
        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreateTime(new Date());

        return redisUtil.set(key,value);
    }

    @GetMapping("/{key}")
    public Object redisGet(@PathVariable String key){
        return redisUtil.get(key);
    }

    @GetMapping("/expire/{key}")
    public boolean expire(@PathVariable String key){
        return redisUtil.expire(key,ExpireTime);
    }
}
