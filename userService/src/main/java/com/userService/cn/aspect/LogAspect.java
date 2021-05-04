package com.userService.cn.aspect;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import eu.bitwalker.useragentutils.UserAgent;

/**   
 * @Description: 日志面向切面编程   
 * @author: 王强
 * @date: 2020年3月30日 上午2:46:11     
 */
@Component
@Aspect
public class LogAspect {
	private static final Logger logger=LoggerFactory.getLogger(LogAspect.class);
	
	//进入方法时间戳
	private Long startTime;
	//方法结束时间戳
	private Long endTime;
	
	
	
	/**   
	 * @Title: pointCut   
	 * @Description: 定义切点  
	 * @param:       
	 * @return: void      
	 * @throws   
	 */
	@Pointcut("execution(* com.userService.cn.controller*.*.*(..))")
	public void pointCut() {};
	
	/**   
	 * @Title: beFore   
	 * @Description: 前置通知 
	 * @param joinPoint      
	 * @return: void      
	 * @throws   
	 */
	@Before("pointCut()")
	public void beFore(JoinPoint joinPoint) {
		//打印请求内容
		printContext(joinPoint);
	}
	
	/**   
	 * @Title: printContext 
	 * @Description: 打印请求内容
	 * @param joinPoint
	 * @return: void
	 * @throws  
	 */
	public void printContext(JoinPoint joinPoint) {
		startTime=System.currentTimeMillis();
		Object[] args=joinPoint.getArgs();
		Signature signature=joinPoint.getSignature();
		//接收到请求，记录请求内容
		ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attributes.getRequest();
		logger.info("请示开始时间: {}"+LocalDateTime.now());
		logger.info("请求Url: {}"+request.getRequestURI().toString());
		logger.info("请求方式 : {}"+request.getMethod());
		logger.info("请求IP: {}"+request.getRemoteAddr());
		logger.info("请求方法: {}"+signature.getDeclaringTypeName()+"."+signature.getName());
		logger.info("请求参数: {}"+Arrays.asList(args));
		//获取请求头中的user-Agent
		UserAgent userAgent=UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		//系统信息
		logger.info("浏览器: {}"+userAgent.getBrowser().toString());
		logger.info("浏览器版本: {}"+userAgent.getBrowserVersion());
		logger.info("操作系统: {}"+userAgent.getOperatingSystem().toString());
	}
	
	/**   
	 * @Title: AfterReturning   
	 * @Description: 后置通知      
	 * @return: void      
	 * @throws   
	 */
	@AfterReturning(pointcut="pointCut()",returning="ret")
	public void AfterReturning(Object ret) {
		endTime=System.currentTimeMillis();
		logger.info("请示结束时间: {}"+LocalDateTime.now());
		logger.info("请求耗时: {}"+(endTime-startTime));
		logger.info("请求返回: {}"+ret);
	}
	
	/**   
	 * @Title: throwsAdvice 
	 * @Description: 异常通知   
	 * @return: void
	 * @throws  
	 */
	@AfterThrowing(pointcut="pointCut()",throwing = "e")
	public void throwsAdvice(Exception e) {
		logger.error("发生异常时间: {}"+LocalDateTime.now());
		logger.error("抛出异常: {}"+e.getMessage());
		
	}
	
	/**
	 * @throws Throwable    
	 * @Title: around 
	 * @Description: 环绕通知（包含前置，后置，异常通知）
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 * @return: Object
	 * @throws  
	 */
	//@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		printContext(joinPoint);
		Object ret=null;
		try {
			//调用目标方法，当我们执行完切面代码之后，还有继续处理业务相关的代码。proceed()方法会继续执行业务代码，并且其返回值，就是业务处理完成之后的返回值。
			ret=joinPoint.proceed();
			logger.info("请求结束时间："+ LocalDateTime.now());
			logger.info("请求耗时：{}" , (System.currentTimeMillis() - startTime));
			// 处理完请求，返回内容
			logger.info("请求返回 : " , ret);
			
		} catch (Exception e) {
			logger.error("发生异常时间: {}"+LocalDateTime.now());
			logger.error("抛出异常: {}"+e.getMessage());
		}
		return ret;
	}
	
	/**   
	 * @Title: after 
	 * @Description: 最终通知（最终通知无论如何都会在目标方法调用过后执行，即使目标方法没有正常的执行完成。）
	 * @return: void
	 * @throws  
	 */
	//@After("pointCut()")
	public void after() {
		logger.info("最终通知 ");
	};
}
