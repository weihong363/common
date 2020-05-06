package com.ironion.demo.pattern.nullobj.entity;

import com.ironion.demo.service.Null;

/**
 * 含空对象实体类的非空实体
 * @author huangwc
 * @date 2020/5/6 10:03 下午
 */
public class Person {

    public final String name;

    /**
     * 编译期常量，初始化为空对象
     */
    public static final Person NULL = new NullPerson();

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * 创建空对象用的静态内部类
     */
    public static class NullPerson extends Person implements Null {

        public NullPerson() {
            super("None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }
}
