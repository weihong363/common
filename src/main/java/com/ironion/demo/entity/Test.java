package com.ironion.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 测试(Test)实体类
 *
 * @author huangwc
 * @since 2020-04-11 11:36:24
 */
@Data
public class Test implements Serializable {
    private static final long serialVersionUID = -30981682801286922L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
