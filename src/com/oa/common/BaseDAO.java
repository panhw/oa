package com.oa.common;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oa.common.utils.GenericsUtils;
import com.oa.common.utils.PageDatas;

/**
 * 该方法为所有DAO都必须继承的类，封装了save() update() delete() 分页查询等通用方法
 * @author sunxs
 * @param <T>  模板参数，传入需要持久化的实体类 如：User.class
 */
@SuppressWarnings("unchecked")
public abstract class BaseDAO<T> implements DAO<T> {

	/** 该变量将获得的模板参数的具体类进行保存 */
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	/** 当前容器中的sessionFactory */
	protected SessionFactory sessionFactory;

	/**
	 * 该方法是Spring向容器中注入sessionFactory的方法
	 * @param sessionFactory	由Spring完成注入
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 该方法删除指定的对象或者对象数组
	 */
	public void delete(Object... objects) {
		for (Object o : objects) {
			getSession().delete(o);
		}
	}

	/**
	 * 该方法删除指定数据表中的所有对象
	 * 
	 * @param entityName
	 *            需要删除的实体的类名称
	 */
	public void deleteAll(String entityName) {
		String hql = "DELETE * FROM " + entityName;
		getSession().createQuery(hql);
	}

	/**
	 * 该方法获得指定ID值的实体对象
	 */
	public T get(int id) {
		return (T)getSession().get(entityClass, id);
	}
	
	/**
	 * 该方法获得指定ID值的实体对象
	 */
	public T get(String id) {
		return (T)getSession().get(entityClass, id);
	}

	/**
	 * 该方法将指定的实体对象存入数据库
	 */
	public void save(T t) {
		getSession().save(t);
	}

	/**
	 * 该方法更新指定的实体对象的信息
	 */
	public void update(T t) {
		getSession().update(t);
	}
	
	/**
	 * 该方法返回分页查询的结果，并且将结果封装在对象中返回
	 * @param startIndex	记录查询开始的序号数
	 * @param maxResult		需要查询的记录数
	 * @return				返回指定的分页结果对象：SeparatePage
	 */
	public PageDatas<T> getSeperatePageData(int startIndex, int maxResult){
		return getPageDatas(startIndex, maxResult, null, null, null);
	}
	
	/**
	 * 该方法返回分页查询的结果，并且将结果封装在对象中返回
	 * @param startIndex	记录查询开始的序号数
	 * @param maxResult		需要查询的记录数
	 * @param whereHQL		条件查询的前缀部分，不需要写"where"关键字，对象的实例只能用"o"，就像：o.id = ?
	 * @param params		条件查询的值部分，依次对应whereHQL中的各个?的值
	 * @return				返回指定的分页结果对象：SeparatePage
	 */
	public PageDatas<T> getPageDatas(int startIndex, int maxResult, String whereHQL,
			Object[] params){
		return getPageDatas(startIndex, maxResult, whereHQL, params, null);
	}

	/**
	 * 该方法返回分页查询的结果，并且将结果封装在对象中返回
	 * @param startIndex	记录查询开始的序号数
	 * @param maxResult		需要查询的记录数
	 * @param whereHQL		条件查询的前缀部分，不需要写"where"关键字，对象的实例只能用"o"，就像：o.id = ?
	 * @param params		条件查询的值部分，依次对应whereHQL中的各个?的值
	 * @return				返回指定的分页结果对象：SeparatePage
	 */
	public PageDatas<T> getSeperatePageData(int startIndex, int maxResult, String whereHQL,
			 Object[] params, LinkedHashMap<String, String> orderBy) {
		Session session = getSession();
		PageDatas<T> pd = new PageDatas<T>();
		String entityName = GenericsUtils.getEntityName(this.entityClass);// 获取实体的名字
		whereHQL = (whereHQL != null && !"".equals(whereHQL.trim()))? ("where " + whereHQL) : "";
		String hql = "SELECT o FROM " + entityName + " o " + whereHQL + buildOrderBy(orderBy);
		System.out.println(hql);
		Query q = session.createQuery(hql);
		setParameters(q, params);
		if(startIndex >= 0 && maxResult > 0) q.setFirstResult(startIndex).setMaxResults(maxResult);//设置分页的起始和终止页数
		pd.setDatas(q.list());//设置查询到的分页的数据
		hql = "SELECT COUNT(o) FROM " + entityName + " o " + whereHQL;
		System.out.println(hql);
		q = session.createQuery(hql);
		setParameters(q, params);
		long totalRecords = (Long)q.uniqueResult();
		pd.setCount(totalRecords);//设置查询到的总记录数
		System.out.println("查询到的总记录数：" + pd.getCount());
		return pd;
	}

	/**
	 * 该方法构造HQL查询语句的条件查询语句
	 * @param q			查询实体
	 * @param params	条件查询的条件的值
	 */
	private void setParameters(Query q, Object[] params) {
		if(params != null){
			for(int i = 0; i < params.length; i++){
				q.setParameter(i, params[i]);
			}
		}
	}

	/**
	 * 该方法组织hql语句中的排序语句部分
	 * @param orderBy	排序的条件集合
	 * @return			返回符合条件的排序语句
	 */
	private String buildOrderBy(LinkedHashMap<String, String> orderBy) {
		String str = " order by ";
		if(orderBy != null && orderBy.size() > 0){
			for(String key : orderBy.keySet()){
				str += ("o." + key + " " + orderBy.get(key) + ",");
			}
			str = str.substring(0, str.length() - 1);
			return str;
		}
		return "";
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<T> find(String hql){
		return this.getSession().createQuery(hql).list();
	}

}
