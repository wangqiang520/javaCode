package com.userService.cn.test.jpa;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestSession {
	
	@ResponseBody
    @RequestMapping(value = "/setCookies",method = RequestMethod.GET)
    public  String setCookies(HttpServletResponse response){
        Cookie cookie=new Cookie("cookie","微信公众号：骄傲的程序员");
//        cookie.setMaxAge(60);             //存活一分钟
//        cookie.setMaxAge(60*60);          //存活一小时
//        cookie.setMaxAge(24*60*60);       //存活一天
        cookie.setMaxAge(365*24*60*60);     //存活一年
        response.addCookie(cookie);
        return "添加成功";
    }
	
	@ResponseBody
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletRequest request){
        Cookie[] cookies =  request.getCookies();//获取保存在request的所有cookie
        if(cookies != null){//判断cookies数组是否为空
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("cookie")){//通过for循环找到想要获取的值
                    System.out.println(cookie.getValue());//控制台输出
                    return cookie.getValue();//返回cookie
                }
            }
        }
        return  null;
    }
	
	@ResponseBody
    @RequestMapping(value = "/setSession",method = { RequestMethod.POST, RequestMethod.GET })
    public  String setCookies(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("data", "微信公众号：骄傲的程序员");
        return "添加成功";
    }
	@ResponseBody
    @RequestMapping(value = "/getSession",method = { RequestMethod.POST, RequestMethod.GET })
    public String getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        String data = (String) session.getAttribute("data");
        return data;
    }
}
