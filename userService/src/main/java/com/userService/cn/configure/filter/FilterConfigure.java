package com.userService.cn.configure.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 王强
 * 过滤器配置类
 */
@Configuration
public class FilterConfigure {
	
	/**   
	 * @Title: charSetFilter 
	 * @Description: 字符编码过滤器
	 * @return
	 * @return: FilterRegistrationBean
	 * @throws  
	 */
	@Bean
	public FilterRegistrationBean charSetFilter() {
		FilterRegistrationBean filterRegistration=new FilterRegistrationBean();
		//指定过过滤器的执行顺序，值越大越靠后执行
		filterRegistration.setOrder(1);
		filterRegistration.setFilter(new CharSetFilter());
		filterRegistration.setName("CharSetFilter");
		filterRegistration.addUrlPatterns("/*");
		return filterRegistration;
	}

	/**   
	 * @Title: loginSetFilter 
	 * @Description: 登录过滤器
	 * @return
	 * @return: FilterRegistrationBean
	 * @throws  
	 */
//	@Bean
	public FilterRegistrationBean loginSetFilter() {
		FilterRegistrationBean filterRegistration=new FilterRegistrationBean();
		filterRegistration.setOrder(2);
		filterRegistration.setFilter(new LoginSetFilter());
		filterRegistration.setName("loginSetFilter");
		filterRegistration.addUrlPatterns("/*");
		return filterRegistration;
	}

}
