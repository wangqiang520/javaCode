package com.cr999.cn.entity.user;

import com.cr999.cn.entity.BaseEntity;
import lombok.Data;
import java.util.Date;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/3/28 17:06 
 */
@Data
public class User extends BaseEntity {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户名（真实姓名）
     */
    private String userName;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别(0:男，1女)
     */
    private short sex;
    /**
     * 用户角色（0正常用户）
     */
    private short userRole;
    /**
     * 学历
     */
    private String education;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 身份证号码
     */
    private String identityCard;
    /**
     * 头像
     */
    private String face;
    /**
     * 头像 200x200x80
     */
    private String face200;
    /**
     * 状态（0:在职，1：离职）
     */
    private Integer status;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 登记时间
     */
    private Date entryDate;

}
