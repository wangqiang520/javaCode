package com.userService.cn.test;

import java.util.List;

public class Teacher {
	private String name;
	private Integer age;
	private String addr;
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	private List<Student> students; 
	public String getName() {
		return name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", addr=" + addr
				+ ", students=" + students + "]";
	}
	
}
