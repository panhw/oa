package com.oa.filemailres.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.oa.common.BaseDAO;
import com.oa.common.utils.PageDatas;
import com.oa.filemailres.dao.inforDao;
import com.oa.filemailres.entity.Information;
import com.oa.personal.entity.Employee;

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


	public void addInfo(Information info) {
		Session session = getSession();
		session.save(info);
	}

	public Map<String, Integer> initeData(Employee emp) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Query query = getSession().createSQLQuery("select count(0) from t_information i where i.manystate='0' and i.status='1' and i.state='1' and i.emp_id=?");
		query.setString(0, emp.getId());
		BigInteger many = (BigInteger) query.uniqueResult();
		map.put("many",many.intValue());
		
		query = getSession().createSQLQuery("select count(0) from t_information i where i.manystate='1' and i.status='1' and i.state='1' and i.emp_id=?");
		query.setString(0, emp.getId());
		BigInteger no = (BigInteger) query.uniqueResult();
		map.put("no",no.intValue());
		
		query = getSession().createSQLQuery("select count(0) from t_information i where i.manystate='2' and i.state='1' and i.emp_id=?");
		query.setString(0, emp.getId());
		BigInteger caogao = (BigInteger) query.uniqueResult();
		map.put("caogao",caogao.intValue());
		
		query = getSession().createSQLQuery("select count(0) from t_information i where i.state='0' and i.emp_id=?");
		query.setString(0, emp.getId());
		BigInteger laji = (BigInteger) query.uniqueResult();
		map.put("laji",laji.intValue());
		map.put("all",no.intValue()+many.intValue());
		return map;
	}

	public List<Information> noreading(Employee emp, int state, int page) {
		List<Information> infors = new ArrayList<Information>();
		if(state == 0){
			
			Query query = getSession().createQuery(
					"from Information i where i.manystate='0' and i.status='1' and i.state='1' and i.emp.id=?");
			query.setParameter(0, emp.getId());
			query.setFirstResult(page);
			query.setMaxResults(10);
			infors = query.list();
			return infors;
		}else if (state == 1){
			Query query = getSession().createQuery(
					"from Information i where i.manystate='1' and i.status='1' and i.state='1' and i.emp.id=?");
			query.setParameter(0, emp.getId());
			query.setFirstResult(page);
			query.setMaxResults(10);
			infors = query.list();
			return infors;
		}else {
			Query query = getSession().createQuery(
					"from Information i where i.status='1' and i.state='1' and i.emp.id=?");
			query.setParameter(0, emp.getId());
	//		query.setParameter("status", "1");
			query.setFirstResult(page);
			query.setMaxResults(10);
			infors = query.list();
			return infors;
		}
	}

	public void delete(String id) {
		Information i = (Information) getSession().get(Information.class,id);
		i.setState("0");
		getSession().update(i);
	}

	public void del(String id) {
		System.out.println("jinlaile");
		Information i = (Information) getSession().get(Information.class,id);
		i.setState("3");
		getSession().update(i);
		
	}

	public void reRead(String empid) {
		Information i = (Information) getSession().get(Information.class,empid);
		i.setStatus("0");
		getSession().update(i);
	}

	public Information read(String empid) {
		Information i = (Information) getSession().get(Information.class,empid);
		i.setStatus("0");
		getSession().update(i);
		return i;
	}

}
