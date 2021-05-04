package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor //全参构造函数
@NoArgsConstructor  //无参构造函数
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
	
	private Long deptNo;
	private String dname;
	private String db_source;
}
