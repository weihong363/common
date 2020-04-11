package com.ironion.demo.controller;

import com.ironion.demo.entity.Test;
import com.ironion.demo.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * 测试(Test)表控制层
 *
 * @author huangwc
 * @since 2020-04-11 14:24:24
 */
@RestController
@RequestMapping("/user")
public class TestController {
    /**
     * 服务对象
     */
    @Resource
    private TestService testService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Test selectOne(@PathVariable("id") Integer id) {
        return this.testService.queryById(id);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Test test){
        try {
            this.testService.insert(test);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回500错误
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Test test){
        try {
            this.testService.update(test);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回500错误
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Integer id){
        if (id.intValue() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            this.testService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
