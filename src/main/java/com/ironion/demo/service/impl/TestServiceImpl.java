package com.ironion.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ironion.demo.entity.Test;
import com.ironion.demo.dao.TestDao;
import com.ironion.demo.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 测试(Test)表服务实现类
 *
 * @author huangwc
 * @since 2020-04-11 11:36:29
 */
@Slf4j
@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestDao,Test> implements ITestService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Test queryById(Integer id) {
        LambdaQueryWrapper<Test> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Test::getId,id);
        Test test = this.getOne(wrapper);
        log.info("根据ID查询「姓名」信息：{}",test.getName());
        return test;
    }

    @Override
    public boolean insert(Test test) {
        log.info("新增「用户」信息：{}",test.getName());
        return save(test);
    }

    @Override
    public boolean update(Test test) {
        LambdaQueryWrapper<Test> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Test::getId,test.getId());
        boolean update = updateById(test);
        log.info("更新「用户」信息：{}",test);
        return update;
    }

    @Override
    public boolean deleteById(Integer id) {
        return removeById(id);
    }
}
