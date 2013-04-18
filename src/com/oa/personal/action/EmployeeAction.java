package com.oa.personal.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.oa.common.BaseAction;
import com.oa.common.exception.UserException;
import com.oa.personal.entity.Employee;
import com.oa.personal.service.EmployeeService;
import com.oa.workflow.ProcessEngineHandler;

public class EmployeeAction extends BaseAction {

	@Resource
	private EmployeeService employeeService;
	private Employee employee ;
	private String msg;
	private String idInfo;
	
	/**
	 * 登录
	 * @return 空串 如果登录成功，否则返回提示信息
	 * @throws IOException 
	 */
	public void login() throws IOException{
		String result="";
		if (StringUtils.isEmpty(employee.getName().trim()) || StringUtils.isEmpty(employee.getPassword().trim()))  result="登录名或密码不能为空";
		else {
			if (employeeService.login(employee))  getSession().setAttribute("employee", employee);
			else result="登录失败，用户名或密码错误！";
		}
		getResponse().getWriter().write(result);
	}
	
	/**
	 * 登陆后跳转的页面
	 * @return
	 */
	public String index(){
		//入口业务写在这里
		return "index";
	}
	
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
