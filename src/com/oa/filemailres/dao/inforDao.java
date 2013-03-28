package com.oa.filemailres.dao;

import java.util.List;
import java.util.Map;

import com.oa.filemailres.entity.Information;
import com.oa.personal.entity.Employee;

/**
 * 消息Dao
 * @author pan
 *
 */
public interface inforDao {

	/**
	 * 初始化消息
	 * @param sql
	 * @return
	 */
	public List<Information> list(String sql) ;
	
	
	/**
	 * 搜索邮件
	 * @param str
	 * @return
	 */
	public List<Information> select(String str);
	
	/**
	 * 分页查找
	 * @param sql
	 * @param star
	 * @param step
	 * @return
	 */
	public List<Information> list(String sql,int star ,int step) ;
	
	/**
	 * 存消息
	 * @param info
	 */
	public void addInfo(Information info);
	
	/**
	 * 初始化参数 拿到各种状态数据  many群未读  no未读  caogao草稿箱  laji 垃圾箱
	 * @param emp
	 * @return
	 */
	public Map<String,Integer> initeData(Employee emp);
}
