package com.zll.riskcontrol.domain;

public class Domin {
	private Long id;
	private int delFlag;
	private String createTime;
	private String updateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Domin [id=" + id + ", delFlag=" + delFlag + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
	
}
