package com.userService.cn.test;

import java.math.BigDecimal;
import java.util.UUID;

import com.google.gson.Gson;
import com.userService.cn.po.UserPo;
import com.userService.cn.test.jpa.User;

import net.sf.json.JSONObject;


public class test3 {
	public static void main(String[] args) {
		/*String x = "string";
		String y = "string";
		String z = new String("string");
		String b = new String("string");
		System.out.println(x==y); // true
		System.out.println(x==z); // false
		System.out.println(x.equals(y)); // true
		System.out.println(x.equals(z)); // true
		
		System.out.println(z==b); // true
		
		User u1=new User();
		u1.setAddress("1");
		User u2=new User();
		u2.setAddress("1");
		
		System.out.println(u1==u2);
		System.out.println(u1.equals(u2));
		
		String str1 = "通话";
		String str2 = "重地";
		 System.out.println(str1.hashCode()+"=="+str2.hashCode());
		 System.out.println(str1==str2);
		 System.out.println(str1.equals(str2));*/
		 
		 UserPo po=new UserPo();
		 po.setUserLogin("wangqiang");
		 po.setUserName("王强");
		 Gson gson = new Gson();
		 String json=gson.toJson(po);
		 System.out.println(json);
		 
		 Gson gsons = new Gson();
		 UserPo pos=gsons.fromJson(json, UserPo.class);
		 System.out.println(pos.toString());
		 
		// JSONObject JSONOBJECT=JSONObject.parseObject(po);
		// JSONObject.toJavaObject(JSONOBJECT,UserPo.class);
		 
		 JSONObject obj = JSONObject.fromObject(po);//再使用JsonObject遍历一个个的对像
		 UserPo oo = (UserPo)obj.toBean(obj,UserPo.class);
		 System.out.println(oo.toString());
		 
		 System.out.println(obj.toString());
		 JSONObject jsonObject=JSONObject.fromObject(obj.toString());
		 UserPo stu=(UserPo)JSONObject.toBean(jsonObject, UserPo.class);
	     System.out.println(stu.toString());
		 
	}
}
