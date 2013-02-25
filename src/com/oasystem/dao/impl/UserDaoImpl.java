package com.oasystem.dao.impl;

import java.util.List;

import com.oasystem.dao.UserDao;
import com.oasystem.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public void save(User user) {
		org.hibernate.Session sess=getSession();

		//org.hibernate.Transaction tx=sess.beginTransaction();
		sess.save(user);
	//tx.commit();
		System.out.println(user);

	}

	public void update(User user) {
		// TODO Auto-generated method stub

	}

	public User get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
