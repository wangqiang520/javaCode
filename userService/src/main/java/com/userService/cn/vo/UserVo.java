package com.userService.cn.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor //全参构造函数
@NoArgsConstructor  //无参构造函数
@Data
@Accessors(chain=true)
public class UserVo {
	@NotBlank(message="用户名不能为空！")
	private String userName;
	
	@NotBlank(message="登录用户名不能为空!")
	private String userLogin;
	
	@NotBlank(message="密码不能为空！")
	@Size(min=6,max=15,message="密码长度6-15位")
	private String passWord;
	
	@NotNull(message="性别不能为空！")
	@Min(value=0,message="性别只能是男和女（0：男，1：女）")
	@Max(value=1,message="性别只能是男和女（0：男，1：女）")
	private Byte sex;
	
	@NotNull(message="证件类型不能为空！")
	@Min(value=0,message="证件类型只能是（0：身份证）")
	private Byte idCardTpye;
	
	@NotBlank(message="证件号不能为空！")
	@Size(min=18,max=18,message="证件号长度要18位")
	private String idCard;
	
	@NotBlank(message="邮箱不能为空！")
	@Email(message="请输入正确的邮箱格式!")
	private String email;
	
	@NotBlank(message="地址不能为空！")
	private String address;
	
	@NotNull(message="手机号码不能为空！")
	@Size(min=11,max=11,message="手机号码长度要11位")
	@Pattern(regexp="^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$",message="手机号不正确!")
	private String telephone;
}
