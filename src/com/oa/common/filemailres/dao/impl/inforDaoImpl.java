package com.oa.filemailres.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.oa.common.BaseDAO;
import com.oa.common.utils.PageDatas;
import com.oa.filemailres.dao.inforDao;
import com.oa.filemailres.entity.Information;

public class inforDaoImpl extends BaseDAO<Information> implements inforDao {

	public List<Information> list(String sql) {
		List<Information> list = new ArrayList<Information>();
		Query query =  getSession().createQuery(sql);
		list = query.list();
		return list;
	}

	public PageDatas<Information> getPageDatas(int startIndex, int maxResult,
			String whereHQL, Object[] params,
			LinkedHashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public List<Information> select(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Information> list(String sql, int star, int step) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addInfo(Information info) {
		Session session = getSession();
		session.save(info);
	}

}
