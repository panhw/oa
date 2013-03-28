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
		/*String sql="from Information i where i.manystate='0' and i.status='1' and i.emp.id="+"'"+emp.getId()+"'";
		List<Information> infos = infordao.list(sql);	
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("many", infos.size());
		String sql2="from Information i where i.manystate='1' and i.status='1' and i.emp.id="+"'"+emp.getId()+"'";
		infos = infordao.list(sql2);
		map.put("no", infos.size());
		String sql3 = "select count(o) from Information i where i.manystate='3' and i.emp.id="+"'"+emp.getId()+"'";
		int c = infordao.list(sql3);*/
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
		return map;
	}

}
