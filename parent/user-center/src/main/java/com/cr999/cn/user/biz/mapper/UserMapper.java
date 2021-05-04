package com.cr999.cn.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cr999.cn.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件描述：
 * 用户Mapper
 * @author wangqiang
 * @date
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
