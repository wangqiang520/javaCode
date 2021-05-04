package test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.userService.cn.po.BasePo;

import cn.afterturn.easypoi.excel.annotation.Excel;

@Entity
public class UserExcel extends BasePo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@Column(name = "user_name")
    @Excel(name = "用户姓名" ,orderNum = "1")
	private String userName;
	@Column(name = "user_login")
    @Excel(name = "用户登录" ,orderNum = "2")
	private String userLogin;
	@Column(name = "pass_word")
    @Excel(name = "用户密码" ,orderNum = "3")
	private String passWord;
	@Column(name = "sex")
    @Excel(name = "性别" ,orderNum = "4")
	private Byte sex;
	@Column(name = "idCard_tpye")
    @Excel(name = "证件类型" ,orderNum = "5")
	private Byte idCardTpye;
	
	@Column(name = "idCard")
    @Excel(name = "证件号码" ,orderNum = "6")
	private String idCard;
	
	@Column(name = "email")
    @Excel(name = "邮箱" ,orderNum = "7")
	private String email;
	@Column(name = "address")
    @Excel(name = "地址" ,orderNum = "8")
	private String address;
	@Column(name = "telephone")
    @Excel(name = "联系电话" ,orderNum = "9")
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
