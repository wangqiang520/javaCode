package com.userService.cn.po;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor //全参构造函数
@NoArgsConstructor  //无参构造函数
//@Data
@Accessors(chain=true)
public class UserPo extends BasePo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userName;
	private String userLogin;
	private String passWord;
	private Byte sex;
	private Byte idCardTpye;
	private String idCard;
	private String email;
	private String address;
	private String telephone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Byte getSex() {
		return sex;
	}
	public void setSex(Byte sex) {
		this.sex = sex;
	}
	public Byte getIdCardTpye() {
		return idCardTpye;
	}
	public void setIdCardTpye(Byte idCardTpye) {
		this.idCardTpye = idCardTpye;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "UserPo [id=" + id + ", userName=" + userName + ", userLogin=" + userLogin + ", passWord=" + passWord
				+ ", sex=" + sex + ", idCardTpye=" + idCardTpye + ", idCard=" + idCard + ", email=" + email
				+ ", address=" + address + ", telephone=" + telephone + "]";
	}
	
}
