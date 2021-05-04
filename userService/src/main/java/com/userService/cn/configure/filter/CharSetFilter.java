package com.userService.cn.configure.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author 王强
 * 字符编码过滤器
 */
//@Component
//@WebFilter(filterName="CharSetFilter",urlPatterns="/*")
//@Order(2)//指定过过滤器的执行顺序，值越大越靠后执行
public class CharSetFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("创建字符编码过滤器");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//获得请求的路径
		String path=req.getServletPath();
		System.out.println("字符编码过滤器拦截到的路径为:"+path);
		
		//请求旅行
		arg2.doFilter(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("销毁字符编码过滤器");
	}

}
