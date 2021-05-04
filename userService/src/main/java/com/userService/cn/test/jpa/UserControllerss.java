/*package com.userService.cn.test.jpa;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.cn.util.DownloadFile;
import com.userService.cn.util.HttpUtil;

@RestController
@RequestMapping("/test")
public class UserControllerss {
	
	@Autowired
	UserRepository userRepository ;
	
	@RequestMapping("test1")
	public void test1(HttpServletResponse response) {
		List<User> list=null;//userRepository.findAll(); 
		User u=userRepository.findByAddress("2");
		System.out.println(u.toString());
		System.out.println(list);
		try {
			//test2.download("C:\\Users\\王强\\Desktop\\html\\lombok.jar", response, false, "44.jar");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	String filePath="http://edoc.hualife.cc/e-doc/download?edoc_id=013B3D298C82657AA30AE0B60363DD6D35D55B2499C3FDAD&sign=4ada758f0e1ddf6a5c75b02b6306a2ed"; //要访问的链接  
	//String filePath="C:\\Users\\王强\\Downloads\\md5.rar";
	
	@RequestMapping("test2")
	public void test2(HttpServletResponse response) throws Exception {
		
		DownloadFile.downloadFile(response, filePath, true, "test2.pdf");
	}
	
	@RequestMapping("test3")
	public void test3(HttpServletResponse response) throws Exception {
		File file=new File(filePath);
		InputStream in=new FileInputStream(file);
		DownloadFile.downloadFileStream(response, in, "test3.pdf");
		
	}
	
	@RequestMapping("test4")
	public void test4(HttpServletResponse response) throws Exception {
		String s=HttpUtil.sendGet(filePath, "utf-8");
		InputStream is = new ByteArrayInputStream(s.getBytes());
		DownloadFile.downloadFileStream(response, is, "test4.pdf");
		
	}
	
	 
}
*/