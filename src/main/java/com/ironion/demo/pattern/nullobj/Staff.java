package com.ironion.demo.pattern.nullobj;

import com.ironion.demo.pattern.nullobj.entity.Person;
import com.ironion.demo.pattern.nullobj.entity.Position;

import java.util.ArrayList;

/**
 * 继承自ArrayList的一个List类
 * @author huangwc
 * @date 2020/5/6 10:23 下午
 */
public class Staff extends ArrayList<Position> {
    @Override
    public boolean add(Position position) {
        return super.add(position);
    }

    /**
     * 重载add方法
     * @param postName
     * @param person
     */
    public void add(String postName,Person person){
        //上面覆盖的add方法
        this.add(new Position(postName,person));
    }

    /**
     * 重载add方法
     * @param postNames
     */
    public void add(String... postNames) {
        for (String postName : postNames) {
            // 创建空职位，此处调用的是默认的从父类继承来的add方法
            add(new Position(postName));
        }
    }

    /**
     * 构造器
     * @param postNames
     */
    public Staff(String... postNames){
        this.add(postNames);
    }

    /**
     * 判断职位是否可以填充
     * @param postName
     * @return
     */
    public boolean positionAvailable(String postName){
        // 此处的this表示的是调用此方法的Staff对象
        for (Position position : this) {
            if (postName.equals(position.getPostName()) && Person.NULL == position.getPerson()){
                return true;
            }
        }
        return false;
    }

    /**
     * 填充职位
     * @param postName
     * @param hire
     */
    public void fillPosition(String postName,Person hire){
        for (Position position:this){
            if (postName.equals(position.getPostName()) && Person.NULL == position.getPerson()){
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position " + postName + "not available");
    }

    /**
     * 测试
      * @param args
     */
    public static void main(String[] args) {
        Staff staff = new Staff("President","CTO",
                "Marketing Manager","Product Manager",
                "Project Lead","Software Engineer",
                "Software Engineer","Software Engineer",
                "Software Engineer","Test Engineer","Technical Writer");
        staff.fillPosition("Project Lead",new Person("Janet"));
        staff.fillPosition("President",new Person("Aaron"));
        if (staff.positionAvailable("Software Engineer")){
            staff.fillPosition("Software Engineer",new Person("Bob"));
        }
        System.out.println(staff);
    }
}
