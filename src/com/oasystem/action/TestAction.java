package com.oasystem.action;

import com.oasystem.entity.User;
import com.oasystem.service.UserService;

public class TestAction {

	private UserService userService;
	private User user = new User();
	private String msg;
	private String idInfo;
	
	
	public static final String SUCCESS = "success";
	
	
	public void setUserService(UserService userService) {
		
		this.userService = userService;
	}
	
	
	
	public String execute() {
		
		userService.register(user);
		
		msg=user.toString();
		return SUCCESS;
	}


	public String getInfo() {
		
		userService.getInfo(idInfo);
		return "error";
	}

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
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
	
	
	
	
}
