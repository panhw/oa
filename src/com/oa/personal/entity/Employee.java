/***********************************************************************
 * Module:  Employee.java
 * Author:  Administrator
 * Purpose: Defines the Class Employee
 ***********************************************************************/

package com.oa.personal.entity;

import java.util.Date;

import com.oa.common.enumeration.Sex;

/**
 * 员工
 * @author sunxs
 * 
 */
public class Employee {
	/** 主键 */
	private Integer id;
	/** 员工的姓名 */
	private String name;
	/** 员工密码 */
	private String password;
	/** 员工的真实姓名 */
	private String realName;
	/** 员工的性别 */
	private Sex sex;
	/** 员工的联系电话 */
	private String phone;
	/** 员工的电子邮件 */
	private String email;
	/** 员工的照片路径 */
	private String imageUrl;
	/** 员工在职状态，true为在职，false为离职 */
	private Boolean visible;
	/** 员工的出生日期 */
	private Date birthday;
	/** 员工所属部门 */
	private Department department;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
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