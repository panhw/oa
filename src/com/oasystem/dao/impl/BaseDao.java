package com.oasystem.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *应为每个dao都需要sessionFactory所有定义了一个最基本的DAO所有的到都必须要继承
 * @author pan
 *
 */
public class BaseDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 获得hibernate 的session
	 * @return session
	 */
	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
}
