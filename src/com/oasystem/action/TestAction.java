package com.oasystem.action;

import com.oasystem.entity.User;
import com.oasystem.service.UserService;

public class TestAction {

	private UserService userService;
	private User user = new User();
	private String msg;
	
	
	
	public static final String SUCCESS = "success";
	
	
	public void setUserService(UserService userService) {
		
		this.userService = userService;
	}
	
	
	
	public String execute() {
		System.out.println("++++++++++++");
		//user.setId("123");
		System.out.println(user);
		userService.register(user);
		
		msg=user.toString();
		return SUCCESS;
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
	
	
	
}
