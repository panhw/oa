package com.oa.personal.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.oa.common.BaseDAO;
import com.oa.common.utils.PageDatas;
import com.oa.personal.entity.Employee;

public class EmployeeDAO extends BaseDAO<Employee>{

	public Employee findByEmployeeName;


	public Employee findByNamePassword(String userName, String encodingPass) {
		String whereSql="from Employee o where o.name=? and o.password=?";
		Query q=getSession().createQuery(whereSql).setString(0, userName).setString(1, encodingPass);
		List<Employee> lst=q.list();
		return 0==lst.size()?null:lst.get(0);
	}


	public PageDatas<Employee> getPageDatas(int startIndex, int maxResult,
			String whereHQL, Object[] params,
			LinkedHashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		return null;
	}




}
