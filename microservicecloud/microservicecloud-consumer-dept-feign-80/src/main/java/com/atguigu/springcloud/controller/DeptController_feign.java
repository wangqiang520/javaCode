package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

@RestController
public class DeptController_feign {
	@Autowired
	private DeptClientService deptClientService;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return deptClientService.add(dept);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return deptClientService.get(id);
	}
	
	@RequestMapping(value="/consumer/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return deptClientService.list();
	}
}
