package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.formula.functions.T;
import org.apache.tomcat.jni.Buffer;

import com.userService.cn.po.UserPo;

public class ExportCSV {
	
	
	public static void main(String[] args) throws Exception {
		/*String fieldName="userName";
		Method m=getMethod(new UserPo(), fieldName);
		System.out.println(m.invoke(new UserPo()));*/
		Map<String,String> titleMap=new HashMap<String, String>();
		titleMap.put("id", "id");
		titleMap.put("userName", "用户名");
		titleMap.put("userLogin", "登录名");
		titleMap.put("passWord", "密码");
		List<UserPo> dataList=new ArrayList<UserPo>();
		UserPo u=new UserPo();
		u.setUserName("王强");
		u.setUserLogin("wangqiang");
		u.setId(1);
		u.setPassWord("1234");
		dataList.add(u);
		csv(dataList, titleMap, UserPo.class);
		
		
	}
	
	public static Object getMethod(Object o,String fieldName) throws Exception {
		Class c=o.getClass();
		Field field=c.getField(fieldName);
		StringBuffer sb=new StringBuffer();
		sb.append("get");
		sb.append(fieldName.substring(0, 1).toUpperCase());
		sb.append(fieldName.substring(1));
		Method m=c.getMethod(sb.toString());
		return m.invoke(o);
	}
	
	
	public static void csv(List<?> dataList,Map<String,String> titleMap,Class<?> c) throws Exception {
		
		//标题
		StringBuffer bf=new StringBuffer();
		for(String key:titleMap.keySet()) {
			bf.append(titleMap.get(key));
			bf.append(",");
		}
		bf.append("\n");
		System.out.println(bf.toString());
		
			for(Object obj:dataList) {
				for(String key:titleMap.keySet()) {
					Class cc=obj.getClass();
					Field f=cc.getDeclaredField(key);
					f.setAccessible(true);
					StringBuffer sb=new StringBuffer();
					sb.append("get");
					sb.append(key.substring(0,1).toUpperCase());
					sb.append(key.substring(1));
					Method m=cc.getMethod(sb.toString());
					bf.append(m.invoke(obj)).append(",");
			}
		}
		System.out.println(bf.toString());
		
		
		
	}

}
