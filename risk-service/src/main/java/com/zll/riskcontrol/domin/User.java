package com.zll.riskcontrol.domin;

public class User extends Domin{
	private int userId;
	private String phone;
	private String realName;
	private String sex;
	private String birthday;
	private int idCardType;
	private String idCardNo;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getIdCardType() {
		return idCardType;
	}
	public void setIdCardType(int idCardType) {
		this.idCardType = idCardType;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", phone=" + phone + ", realName=" + realName + ", sex=" + sex + ", birthday="
				+ birthday + ", idCardType=" + idCardType + ", idCardNo=" + idCardNo + "]";
	}
	
}
