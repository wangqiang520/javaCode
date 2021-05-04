package com.cr999.cn.user.controller;

import com.cr999.cn.common.DataResponse;
import com.cr999.cn.common.ResultEnum;
import com.cr999.cn.common.vo.UserVo;
import com.cr999.cn.entity.user.User;
import com.cr999.cn.user.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文件描述：
 * 用户控制层
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/5 0:23 
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test1")
    public DataResponse test1(){
        User list = userService.getById("1");
        return new DataResponse(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(),list);
    }

    @PostMapping("/login")
    public DataResponse login(UserVo userVo){
        return null;

    }

}
