package com.oa.common;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;

import com.oa.common.utils.PageDatas;


/**
 * 该类定义所有DAO层类的通用方法
 * @author sunxs
 *
 * @param <T>
 */

public interface DAO<T> {
	
	/**
	 * 向数据库中添加一个T对象
	 * @param t	需要添加进数据库的对象的实例
	 */
	public void save(T t);
	
	/**
	 * 删除指定的对象
	 * @param objects	需要删除的对象
	 */
	public void delete(Object... objects);
	
	/**
	 * 从数据库中查询指定ID的数据
	 * @param id	需要查询的数据的ID值
	 * @return		返回符合条件的实体
	 */
	public T get(int id);
	
	/**
	 * 更新一个实体的信息
	 * @param t	更新后的实体
	 */
	public void update(T t);
	
	/**
	 * 该方法返回分页查询的结果，并且将结果封装在对象中返回
	 * @param startIndex	记录查询开始的序号数
	 * @param maxResult		需要查询的记录数
	 * @param whereHQL		条件查询的前缀部分，不需要写"where"关键字，对象的实例只能用"o"，就像：o.id = ?
	 * @param params		条件查询的值部分，依次对应whereHQL中的各个?的值
	 * @param orderBy		排序的条件
	 * @return				返回指定的分页结果对象：SeparatePage
	 */
	public PageDatas<T> getPageDatas(int startIndex, int maxResult, String whereHQL,
			Object[] params, LinkedHashMap<String, String> orderBy);
	
	/**
	 * 获取当前正在使用的Session
	 * @return
	 */
	public Session getSession();
	
	/**
	 * 根据传入的hql语句，执行相应的查询
	 * @param hql	需要执行的hql语句
	 * @return		返回查询到的结果
	 */
	public List<T> find(String hql);
	
}
