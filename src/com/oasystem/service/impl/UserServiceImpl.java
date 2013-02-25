package com.oasystem.service.impl;

import com.oasystem.dao.UserDao;
import com.oasystem.entity.User;
import com.oasystem.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
	}
	public void register(User user) {
		
		userDao.save(user);
	}

}
