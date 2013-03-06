package com.oa.personal.action;

import com.oa.common.BaseAction;
import com.oa.personal.entity.Employee;
import com.oa.personal.service.EmployeeService;

public class EmployeeAction extends BaseAction {

	private EmployeeService employeeService;
	private Employee employee ;
	private String msg;
	private String idInfo;
	
	
	public static final String SUCCESS = "success";
	
	
	public void setUserService(EmployeeService userService) {
		
		this.employeeService = userService;
	}
	
	
	
	public String execute() {
		
		employeeService.register(employee);
		
		return SUCCESS;
	}


	public String getInfo() {
		
		employeeService.getInfo(idInfo);
		return "error";
	}


	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getIdInfo() {
		return idInfo;
	}



	public void setIdInfo(String idInfo) {
		this.idInfo = idInfo;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public EmployeeService getUserService() {
		return employeeService;
	}



	public static String getSuccess() {
		return SUCCESS;
	}



	public EmployeeService getEmployeeService() {
		return employeeService;
	}



	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	
}
