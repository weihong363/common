package com.ironion.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ironion.demo.entity.Test;

/**
 * 测试(Test)表服务接口
 *
 * @author huangwc
 * @since 2020-04-11 11:36:27
 */
public interface ITestService extends IService<Test> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Test queryById(Integer id);

    /**
     * 新增数据
     *
     * @param test 实例对象
     * @return 实例对象
     */
    boolean insert(Test test);

    /**
     * 修改数据
     *
     * @param test 实例对象
     * @return 实例对象
     */
    boolean update(Test test);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
