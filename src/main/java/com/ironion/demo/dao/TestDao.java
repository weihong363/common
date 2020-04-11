package com.ironion.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ironion.demo.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 测试(Test)表数据库访问层
 *
 * @author huangwc
 * @since 2020-04-11 11:36:25
 */
@Mapper
public interface TestDao extends BaseMapper<Test> {

}
