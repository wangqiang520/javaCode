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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.userService.cn.po.UserPo;
import com.userService.cn.service.UserService;
import com.userService.cn.util.ConstantEnum;
import com.userService.cn.util.RedisUtil;

/**
 * @author 王强 登录过滤器
 */
// @Component
// @WebFilter(filterName="CharSetFilter2",urlPatterns="/*")
// @Order(1)//指定过过滤器的执行顺序，值越大越靠后执行
@Configuration
public class LoginSetFilter implements Filter {
	@Autowired
	UserService userService;
	@Value("${allow.path}")
	String allowPath;
	@Autowired
	RedisUtil redisUtil;
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("创建登录过滤器");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		// 允许放行的路径
		String path = req.getServletPath();
		String[] allowPaths = allowPath.split(",");
		//获取session值
		Object obj = req.getSession().getAttribute("loginUser");
		if(obj != null) {
			arg2.doFilter(req, resp);
			return;
		}
		
		// 从redis查询token
		String tokenKey = ConstantEnum.USER_TOKEN_PREFIX.getValue() + req.getParameter("token");
		if(redisUtil.get(tokenKey)!= null) {
			//过期时间
			long expireDate=Long.parseLong(ConstantEnum.EXPIRE_DATE.getValue())/1000;
			//更新过期时间
			redisUtil.expire(tokenKey, expireDate);
			arg2.doFilter(req, resp);
			return;
		}
		for (String url:allowPaths) {
			if (url.equals(path)) {
				// 请求放行
				arg2.doFilter(req, resp);
				return;
			}
		}
		// 用户未登录，跳转到登录界面
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ req.getContextPath() + "/";
		// 跳转到登录页面 
		resp.sendRedirect(basePath + "index.html?redirectURL="+req.getRequestURL());
	}

	@Override
	public void destroy() {
		System.out.println("销毁登录过滤器");
	}

}
