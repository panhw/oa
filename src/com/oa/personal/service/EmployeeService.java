package com.oa.personal.service;

import com.oa.personal.entity.Employee;


public interface EmployeeService {

	/**
	 * @param employee
	 */
	public void register(Employee employee);
	
	public void getInfo(String str);
	
	/**
	 * 登录
	 * @param userName 登录名
	 * @param password 密码
	 * @return
	 */
	public boolean login(Employee employee);
}
