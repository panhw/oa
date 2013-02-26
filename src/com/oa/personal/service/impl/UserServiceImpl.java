package com.oa.personal.service.impl;

import com.oa.personal.dao.UserDao;
import com.oa.personal.entity.User;
import com.oa.personal.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
	}
	public void register(User user) {
		
		userDao.save(user);
	}
	public void getInfo(String str) {
		userDao.get(str);
		
	}

}
