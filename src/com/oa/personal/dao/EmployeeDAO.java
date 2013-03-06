package com.oa.personal.dao;

import java.util.LinkedHashMap;

import org.hibernate.Session;

import com.oa.common.BaseDAO;
import com.oa.common.utils.PageDatas;
import com.oa.personal.entity.Employee;

public class EmployeeDAO extends BaseDAO<Employee>{

	public PageDatas<Employee> getPageDatas(int startIndex, int maxResult,
			String whereHQL, Object[] params,
			LinkedHashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		return null;
	}




}
