package com.userService.cn.po;

import java.io.Serializable;

public class BasePo implements Serializable{
	private static final long serialVersionUID = -5761016114934372640L;
	private String creater;
	private Long createTime;
	private String updater;
	private Long updateTime;
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	
}
