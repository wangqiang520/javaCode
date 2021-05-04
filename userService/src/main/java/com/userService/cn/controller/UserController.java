package com.userService.cn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.userService.cn.po.UserPo;
import com.userService.cn.service.UserService;
import com.userService.cn.util.EncryptionUtils;
import com.userService.cn.util.Result;
import com.userService.cn.util.ResultEnum;
import com.userService.cn.util.ResultUtil;
import com.userService.cn.vo.UserVo;

import test.ExcelUtiles;
import test.UserExcel;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private static Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	/**
	 * @Title: register @Description: 用户注册 @param vo @param
	 * bindingResult @return @return: Result @throws
	 */
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public Result register(@Valid @RequestBody UserVo vo, BindingResult bindingResult) {
		// 校验参数失败
		if (bindingResult.hasErrors()) {
			StringBuilder msg = new StringBuilder();
			List<ObjectError> errList = bindingResult.getAllErrors();
			errList.forEach(err -> {
				msg.append(err.getDefaultMessage());
				msg.append(",");
			});
			
			return ResultUtil.error(ResultEnum.PARAMETER_ERROR.getCode(),
					ResultEnum.PARAMETER_ERROR.getMsg().replaceFirst("%s", msg.toString()));
		}

		// 查询证件号和手机号是否存在
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("telephone", vo.getTelephone());
		map.put("idCardTpye", vo.getIdCardTpye());
		map.put("idCard", vo.getIdCard());
		List<UserPo> userPoList=new ArrayList<UserPo>();;
		try {
			userPoList = userService.queryList(map);
			if (userPoList != null && userPoList.size() > 0)
				return ResultUtil.error(ResultEnum.USERLOGIN_IS_EXISTS.getCode(), "证件号和手机号已存在！");
		} catch (Exception e1) {
			logger.error(e1.getMessage());
		}

		// 注册用户
		// 数据转换
		UserPo po = userVoToUserPo(vo);
		try {
			userService.insert(po);
		} catch (Exception e1) {
			logger.error(e1.getMessage());
			return ResultUtil.error(ResultEnum.ADD_DATA_ERROR.getCode(), ResultEnum.ADD_DATA_ERROR.getMsg());
		}
		return ResultUtil.success();
	}

	/**
	 * @Title: voTOpo @Description: 用户VO转用户PO @param vo @return @return:
	 * UserPo @throws
	 */
	public UserPo userVoToUserPo(UserVo vo) {
		UserPo po = new UserPo();
		// 密码加密
		String passWord = EncryptionUtils.encodeSha256(vo.getPassWord());
		po.setPassWord(passWord);
		po.setAddress(vo.getAddress());
		po.setEmail(vo.getEmail());
		po.setIdCard(vo.getIdCard());
		po.setIdCardTpye(vo.getIdCardTpye());
		po.setSex(vo.getSex());
		po.setTelephone(vo.getTelephone());
		po.setUserLogin(vo.getUserLogin());
		po.setUserName(vo.getUserName());

		long currentTime = System.currentTimeMillis();
		po.setCreateTime(currentTime);
		po.setUpdateTime(currentTime);
		return po;
	}

	/**   
	 * @Title: login 
	 * @Description: 用户登录
	 * @param loginName
	 * @param passWord
	 * @return
	 * @return: Result
	 * @throws  
	 */
	@PostMapping(value="/login")
	@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
	public Result login(String loginName,String passWord,Integer isCookie,HttpServletRequest request,HttpServletResponse response) {
		//判断空
		if(StringUtils.isEmpty(loginName) && StringUtils.isEmpty(passWord))
			return ResultUtil.error(ResultEnum.USERLOGIN_AND_PASSWORD_IS_EMPTY.getCode(), ResultEnum.USERLOGIN_AND_PASSWORD_IS_EMPTY.getMsg());
		return userService.login(loginName, passWord,isCookie,request,response);
	}
	
	@RequestMapping(value = "/list")
	@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
	public Result list(UserVo vo) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userLogin", vo.getUserLogin());
		map.put("userName", vo.getUserName());
		map.put("idCard", vo.getIdCard());
		map.put("telephone", vo.getTelephone());
		
		List<UserPo> list=new ArrayList<UserPo>();;
		try {
			list = userService.queryList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultUtil.success(list);
	}
	
	@RequestMapping(value = "/exportUser")
	@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
	public void exportUser(HttpServletResponse response) {
		UserExcel u=new UserExcel();
		u.setUserName("王强");
		u.setUserLogin("wangqiang\r\nmmmmmmmmmmmmm\r\n");
		List<UserExcel> dataList=new ArrayList<UserExcel>();
		dataList.add(u);
		ExcelUtiles.exportExcel(dataList, "测试名\r\n", "什么名字", UserExcel.class, "测试.xls", response);
	}
	
}
