package com.ironion.demo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * @author huangwc
 * @date 2020/3/5 3:29 下午
 */
public class XmlJsonUtils {
    public static JSONObject xmltoJson(String xml) throws Exception {
        JSONObject jsonObject = new JSONObject();
        Document document = DocumentHelper.parseText(xml);
        //获取根节点元素对象
        Element root = document.getRootElement();
        iterateNodes(root, jsonObject);
        return jsonObject;
    }
    /**
     * 遍历元素
     * @param node 元素
     * @param json 将元素遍历完成之后放的JSON对象
     */
    @SuppressWarnings("unchecked")
    public static void iterateNodes(Element node,JSONObject json){
        //获取当前元素的名称
        String nodeName = node.getName();
        //判断已遍历的JSON中是否已经有了该元素的名称
        boolean judge = nodeName.equals("parcel_trader") || nodeName.equals("parcel_phase") ||
                nodeName.equals("phase_plan_node") || nodeName.equals("phase_plan_building") ||
                nodeName.equals("phase_plan_building_node") ||
                nodeName.equals("phase_plan_building_room");
        if(json.containsKey(nodeName) || judge){
            //该元素在同级下有多个
            Object Object = json.get(nodeName);
            JSONArray array = null;

            if(Object instanceof JSONArray){
                array = (JSONArray) Object;
            }else {
                array = new JSONArray();
                array.add(Object);
            }
            //获取该元素下所有子元素
            List<Element> listElement = node.elements();
            if(listElement.isEmpty()){
                //该元素无子元素，获取元素的值
                int length = node.getTextTrim().length();
                String nodeValue;
//                if (length > 2){
//                    nodeValue = ".0".equals(node.getTextTrim().substring(length - 2,length)) ?
//                            node.getTextTrim().substring(0,length - 2) : node.getTextTrim();
//                }else {
                    nodeValue = node.getTextTrim();
//                }
                array.add(nodeValue);
                json.put(nodeName, array);
                return ;
            }
            //有子元素
            JSONObject newJson = new JSONObject();
            //遍历所有子元素
            for(Element e:listElement){
                //递归
                iterateNodes(e,newJson);
            }
            array.add(newJson);
            json.put(nodeName, array);
            return ;
        }
        //该元素同级下第一次遍历
        //获取该元素下所有子元素
        List<Element> listElement = node.elements();
        if(listElement.isEmpty()){
            //该元素无子元素，获取元素的值
            int length = node.getTextTrim().length();
            String nodeValue;
//            if (length > 2){
//                nodeValue = ".0".equals(node.getTextTrim().substring(length - 2,length)) ?
//                        node.getTextTrim().substring(0,length - 2) : node.getTextTrim();
//            }else {
                nodeValue = node.getTextTrim();
//            }
            json.put(nodeName, nodeValue);
            return ;
        }
        //有子节点，新建一个JSONObject来存储该节点下子节点的值
        JSONObject object = new JSONObject();
        //遍历所有一级子节点
        for(Element e:listElement){
            //递归
            iterateNodes(e,object);
        }
        json.put(nodeName, object);
        return ;
    }
}
