package com.oa.personal.service;

import com.oa.personal.entity.Employee;


public interface EmployeeService {

	/**
	 * @param employee
	 */
	public void register(Employee employee);
	
	public void getInfo(String str);
}
