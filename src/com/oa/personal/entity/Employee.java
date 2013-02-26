/***********************************************************************
 * Module:  Employee.java
 * Author:  Administrator
 * Purpose: Defines the Class Employee
 ***********************************************************************/

package com.oa.personal.entity;

import java.util.Date;

/**
 * 员工
 * @author sunxs
 * 
 */
public class Employee {
	/** 主键 */
	private Integer id;
	/** 员工的姓名 */
	private String username;
	/** 员工密码，50位 */
	private String password;
	/** 员工的真实姓名，10位 */
	private String realname;
	/** 员工的性别 */
	
	/** 员工的联系电话 */
	private String phone;
	/** 员工的电子邮件 */
	private String email;
	/** 员工的照片路径 */
	private String imageUrl;
	/** 员工在职状态，true为在职，false为离职 */
	private Boolean visible;
	/** 员工登录的时间 */
	private Date loginDate;
	/** 员工登录的IP地址 */
	private String ipAddress;
	/** 员工的出生日期 */
	private Date birthday;
	/** 员工拥有的权限 */
	/** 员工所属部门 */
	private Department department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

}