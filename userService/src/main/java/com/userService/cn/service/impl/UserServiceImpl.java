package com.userService.cn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.userService.cn.dao.UserDao;
import com.userService.cn.po.UserPo;
import com.userService.cn.service.UserService;
import com.userService.cn.util.ConstantEnum;
import com.userService.cn.util.EncryptionUtils;
import com.userService.cn.util.RedisUtil;
import com.userService.cn.util.Result;
import com.userService.cn.util.ResultEnum;
import com.userService.cn.util.ResultUtil;
import com.userService.cn.util.TokenUtil;

import net.sf.json.JSONObject;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserDao userDao;
	@Autowired
	RedisUtil redisUtil;

	@Override
	public UserPo findById(Integer id) {
		return id !=null?userDao.findById(id):new UserPo();
	}

	@Override
	public List<UserPo> queryList(Map<String, Object> map) {
		return userDao.queryList(map);
	}

	@Override
	public boolean insert(UserPo po){
		return userDao.insert(po)>0?true:false;
	}

	@Override
	public boolean delete(Integer id) {
		return id != null?userDao.delete(id)>0?true:false:false;
	}

	@Override
	public boolean update(UserPo po) {
		return userDao.update(po)>0?true:false;
	}

	@Override
	public Result login(String userLogin, String passWord,Integer isCookie,HttpServletRequest request,HttpServletResponse response) {
		UserPo po=new UserPo();
		po.setUserLogin(userLogin);
		po.setPassWord(EncryptionUtils.encodeSha256(passWord));
		UserPo userPo=userDao.findByUserLoginAndPassWord(po);
		if(userPo==null)
			return ResultUtil.error(ResultEnum.USERLOGIN_AND_PASSWORD_ERROR.getCode(), ResultEnum.USERLOGIN_AND_PASSWORD_ERROR.getMsg());
		//过期时间
		long expireDate=Long.parseLong(ConstantEnum.EXPIRE_DATE.getValue())/1000;
		//生成token
		String token=UUID.randomUUID().toString().replace("-", "");
		
		//保存Session,
		HttpSession session=request.getSession();
		session.setAttribute("userPo", userPo);
		
		if(isCookie !=null && isCookie==1) {
			//保存Cookies
			Cookie userLoginCookie=new Cookie("userLogin", userLogin);
			Cookie passWordCookie=new Cookie("passWord", passWord);
			userLoginCookie.setMaxAge((int)expireDate*60*24);
			passWordCookie.setMaxAge((int)expireDate*60*24);
			userLoginCookie.setPath("/");
			passWordCookie.setPath("/");
			response.addCookie(userLoginCookie);
			response.addCookie(passWordCookie);
		}
		//保存redis
		String json=JSONObject.fromObject(po).toString();
		boolean flag=redisUtil.set(ConstantEnum.USER_TOKEN_PREFIX.getValue()+token, json, expireDate);
		String a=(String) redisUtil.get(ConstantEnum.USER_TOKEN_PREFIX.getValue()+token);
		System.out.println("==========="+a);
		if(!flag) {
			logger.error("错误码:{},错误信息:{}",ResultEnum.REDIS_ADD_ERROR.getCode(), ResultEnum.REDIS_ADD_ERROR.getMsg());
			return ResultUtil.error(ResultEnum.REDIS_ADD_ERROR.getCode(), ResultEnum.REDIS_ADD_ERROR.getMsg());
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("token", token);
		currentLoginUser(token);
		return ResultUtil.success(map);
	}
	@Override
	public UserPo currentLoginUser(String token) {
		String jsonString=(String) redisUtil.get(ConstantEnum.USER_TOKEN_PREFIX.getValue()+token);
		if("null".equals(jsonString))
			return null;
		JSONObject jsonObject=JSONObject.fromObject(jsonString);
		JSONObject.toBean(jsonObject, UserPo.class);
		UserPo po=(UserPo) JSONObject.toBean(jsonObject, UserPo.class);
		return po;
	}

}
