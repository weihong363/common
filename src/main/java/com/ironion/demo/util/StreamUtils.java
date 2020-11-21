package com.ironion.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Ironion
 * @date 2020/11/16 6:04 下午
 */
public class StreamUtils {

    /**
     * 判断元素能否加到set中（作为filter条件来做去重）
     *
     * @param keyExtract
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T,?> keyExtract){
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtract.apply(t));
    }

    static class Man {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        Man(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Man{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
//    public static void main(String[] args) {
//        List<Man> list = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Man man = new Man("张三", i);
//            list.add(man);
//        }
//        List<String> collect = list.stream().filter(distinctByKey(Man::getName)).map(m -> m.getName()).collect(Collectors.toList());
//        System.out.println(collect);
//    }
}
