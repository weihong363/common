package com.ironion.demo.pattern.nullobj.entity;

/**
 * @author huangwc
 * @date 2020/5/6 10:10 下午
 */
public class Position{

    /**
     * 职位名
     */
    private String postName;

    private Person person;

    public Position(String postName,Person person){
        this.postName = postName;
        //对象为空，就转为NullPerson对象
        this.person = null == person ? Person.NULL : person;
    }

    public Position(String postName) {
        this.postName = postName;
        //没传，直接设为NullPerson对象
        this.person = Person.NULL;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = null == person ? Person.NULL : person;
    }

    @Override
    public String toString() {
        return "Position{" +
                "postName='" + postName + '\'' +
                ", person=" + person +
                '}';
    }
}
