package com.userService.cn.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class TestJson {
	public static void main(String[] args) {
		a();
	}
	
	public static void a() {
		String objectStr="{\"name\":\"JSON\",\"age\":\"24\"}";
        String arrayStr="[{\"name\":\"JSON\",\"age\":\"24\"}]";
    
        //1、使用JSONObject
        JSONObject jsonObject=JSONObject.fromObject(objectStr);
        Student stu=(Student)JSONObject.toBean(jsonObject, Student.class);
        System.out.println(stu.toString());
        
        //2、使用JSONArray
        JSONArray jsonArray=JSONArray.fromObject(arrayStr);
        //获得jsonArray的第一个元素
        Object o=jsonArray.get(0);
        JSONObject jsonObject2=JSONObject.fromObject(o);
        Student stu2=(Student)JSONObject.toBean(jsonObject2, Student.class);
        System.out.println("stu:"+stu);
        System.out.println("stu2:"+stu2);
	}
}
