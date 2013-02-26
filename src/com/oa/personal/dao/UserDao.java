package com.oa.personal.dao;

import java.util.List;

import com.oa.personal.entity.User;

public interface UserDao {
	
	public void save(User user);
	
	public void update(User user);
	
	public User get(String id);
	
	public List<User> list();
}
