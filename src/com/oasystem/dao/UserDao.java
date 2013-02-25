package com.oasystem.dao;

import java.util.List;

import com.oasystem.entity.User;

public interface UserDao {

	public void save(User user);
	
	public void update(User user);
	
	public User get(String id);
	
	public List<User> list();
}
