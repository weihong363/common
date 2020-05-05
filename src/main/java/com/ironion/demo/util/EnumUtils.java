package com.ironion.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;


public class EnumUtils {
    private static Logger logger = LoggerFactory.getLogger(EnumUtils.class);

    private static Map<Class,Object> map = new ConcurrentHashMap<>();

    /**
     * 根据条件获取枚举对象
     * @param className 枚举类
     * @param predicate 筛选条件
     * @param <T>
     * @return
     */
    public static <T> Optional<T> getEnumObject(Class<T> className, Predicate<T> predicate) {
        if (!className.isEnum()) {
            logger.info("Class 不是枚举类");
            return null;
        }
        Object obj = map.get(className);
        T[] ts = null;
        if (obj == null) {
            ts = className.getEnumConstants();
            map.put(className, ts);
        } else {
            ts = (T[]) obj;
        }
        return Arrays.stream(ts).filter(predicate).findAny();
    }

    /**
     * 把枚举转成Map，并初始化map每个节点的值为map
     * 适合初始化枚举的值为map的Map对象
     * @param enumClass
     * @param valueMap
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> Map<String, Map> getEnumMap(Class<E> enumClass,Map valueMap) {
        Map<String, Map> map = new LinkedHashMap();
        Enum[] arr$ = (Enum[])enumClass.getEnumConstants();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            E e = (E) arr$[i$];
            Map tempMap = new HashMap();
            tempMap = clone(valueMap);
            tempMap.put("id", e.name().toLowerCase() + valueMap.get("lot"));
            map.put(e.name().toLowerCase(), tempMap);
        }

        return map;
    }

    /**
     * 把枚举转成Map，并初始化map每个节点的值为map
     * 适合初始化枚举的值为map的Map对象
     * @param enumClass
     * @param <E>
     * @return
     */
    public static <E extends Enum<E>> Map<String,List> getEnumMapList(Class<E> enumClass) {
        Map<String,List> map = new LinkedHashMap<>();
        Enum[] arr$ = (Enum[])enumClass.getEnumConstants();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            E e = (E) arr$[i$];
            //特殊情况，出此下策
//            String valueByName = BpmInfoPropsEnum.getValueByName(e.name());
//            map.put(valueByName,new ArrayList());
        }

        return map;
    }

    public static <T extends Serializable> T clone(Map obj) {
        T clonedObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (T) ois.readObject();
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return clonedObj;
    }
}
