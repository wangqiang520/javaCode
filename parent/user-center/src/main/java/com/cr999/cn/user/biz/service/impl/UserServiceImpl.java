package com.cr999.cn.user.biz.service.impl;/**
 * 文件描述：
 *
 * @author wangqiang
 * @date
 */

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cr999.cn.entity.user.User;
import com.cr999.cn.user.biz.mapper.UserMapper;
import com.cr999.cn.user.biz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/5 0:20 
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

}
