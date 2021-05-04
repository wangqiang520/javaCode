package com.userService.cn.test.jpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false,updatable=false,length=31)
	private String id;
	
	@Column(name="user_name",columnDefinition="VARCHAR(60) DEFAULT '' COMMENT '鐢ㄦ埛濮撳悕'")
	private String userName;
	
	@Column(name="login_name",columnDefinition="VARCHAR(60) DEFAULT '' COMMENT '鐧诲綍濮撳悕'")
	private String loginName;
	
	@Column(name="nation",columnDefinition="VARCHAR(10) DEFAULT '' COMMENT '姘戞棌'")
	private String nation;
	
	@Column(name="pass_word",columnDefinition="VARCHAR(100) DEFAULT '' COMMENT '瀵嗙爜'")
	private String passWord;

	@Column(name="sex",columnDefinition="tinyint DEFAULT 0 DEFAULT 0 COMMENT '鎬у埆'")
	private Byte sex;

	@Column(name="phone",columnDefinition="integer COMMENT '鐢佃瘽'")
	private Integer phone;

	@Column(name="email",columnDefinition="VARCHAR(30) DEFAULT '' COMMENT '閭'")
	private String email;

	@Column(name="credentials",columnDefinition="tinyint DEFAULT 0 DEFAULT 0 COMMENT '璇佷欢绫诲瀷(0:韬唤璇�)'")
	private Byte credentials;

	@Column(name="credentials_number",columnDefinition="VARCHAR(20) DEFAULT '' COMMENT '璇佷欢鍙风爜'")
	private String credentialsNumber;

	@Column(name="dept_id",columnDefinition="VARCHAR(20) DEFAULT '' COMMENT '閮ㄩ棬'")
	private Integer deptId;

	@Column(name="address",columnDefinition="VARCHAR(100) DEFAULT '' COMMENT '鍦板潃'")
	private String address;

	@Column(name="picture",columnDefinition="VARCHAR(255) DEFAULT '' COMMENT '澶村儚'")
	private String picture;

	@Column(name="record_of_formal_schooling",columnDefinition="VARCHAR(10) DEFAULT '' COMMENT '瀛﹀巻'")
	private String recordOfFormalSchooling;

	@Column(name="graduated_from",columnDefinition="VARCHAR(50) DEFAULT '' COMMENT '姣曚笟闄㈡牎'")
	private String graduatedFrom;

	@Column(name="status",columnDefinition="tinyint DEFAULT 1 COMMENT '鐘舵�侊紙0锛氬凡鍒犻櫎锛�1锛氭湭鍒犻櫎锛�'")
	private Byte status;
	
	@Column(name="create_time",columnDefinition="tinyint DEFAULT 0 COMMENT '鍒涘缓鏃堕棿'")
	private Long createTime;
	
	@Column(name="created_by",columnDefinition="tinyint DEFAULT 0 COMMENT '鍒涘缓浜�'")
	private Integer createdBY;
	
	@Column(name="update_time",columnDefinition="tinyint DEFAULT 0 COMMENT '淇敼鏃堕棿'")
	private Long updateTime;
	
	@Column(name="modified_by",columnDefinition="tinyint DEFAULT 0 COMMENT '淇敼浜�'")
	private Integer modifiedBy;
}
