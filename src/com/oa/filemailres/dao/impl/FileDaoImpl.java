package com.oa.filemailres.dao.impl;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;

import com.oa.common.BaseDAO;
import com.oa.common.utils.PageDatas;
import com.oa.filemailres.dao.FileDao;
import com.oa.filemailres.entity.FileVO;
import com.oa.personal.entity.Employee;

public class FileDaoImpl extends BaseDAO<FileVO> implements FileDao {

	public PageDatas<FileVO> getPageDatas(int startIndex, int maxResult,
			String whereHQL, Object[] params,
			LinkedHashMap<String, String> orderBy) {
		return null;
	}

	public List<FileVO> findAllFolders(Employee emp) {
		
		Query query = getSession().createQuery("from FileVO f where f.state != '3'and f.type='0' and f.employee.id = ?");
		query.setParameter(0, emp.getId());
		return query.list();
	}

	public List<FileVO> findAllFiles(String fatherid,int page) {
		Query query = getSession().createQuery("from FileVO f where f.state != '3' and f.fatherfile.id = ?");
		query.setParameter(0, fatherid);
		query.setFirstResult(page);
		query.setMaxResults(15);
		return query.list();
	}
	public List<FileVO> findAllFiles(Employee emp,int page) {
		Query query = getSession().createQuery(
				"from FileVO f where f.state != '3' and f.fatherfile.id is null and f.employee.id = ?");
		query.setParameter(0, emp.getId());
		query.setFirstResult(page);
		query.setMaxResults(15);
		return query.list();
	}

	public FileVO findById(String id) {
		
		return (FileVO) getSession().get(FileVO.class, id);
	}



	public int numAllFiles(Employee emp) {
		Query query = getSession().createSQLQuery(
				"select count(0) from t_file f where f.state != '3'and f.father_id is null and f.emp_id =?");
		query.setParameter(0, emp.getId());
		BigInteger  b = (BigInteger) query.uniqueResult();
		return b.intValue();
	}

	public int numFiles(String fatherid) {
		Query query = getSession().createSQLQuery(
				"select count(0) from t_file f where f.state != '3'and f.father_id = ?");
		query.setParameter(0, fatherid);
		BigInteger  b = (BigInteger) query.uniqueResult();
		return b.intValue();
	}

}
