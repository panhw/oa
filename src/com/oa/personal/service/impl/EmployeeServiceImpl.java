package com.oa.personal.service.impl;

import com.oa.common.utils.MD5;
import com.oa.personal.dao.EmployeeDAO;
import com.oa.personal.entity.Employee;
import com.oa.personal.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	public void setUserDao(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		
	}
	
	public void getInfo(String str) {
		employeeDAO.get(str);
		
	}

	public void register(Employee employee) {
		employeeDAO.save(employee);
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public boolean login(Employee employee) {
		String encodingPass=MD5.MD5Encode(employee.getPassword());
		employee=employeeDAO.findByNamePassword(employee.getName(),encodingPass); 
		return null==employee?false:true;
	}

}
