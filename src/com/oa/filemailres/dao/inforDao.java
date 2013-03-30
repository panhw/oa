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
	 * 查询所有未读
	 * @return 
	 */
	public List<Information> noreading(Employee emp,int state,int page);
	
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
	
	/**
	 * 删除邮件
	 */
	public void delete(String id);
	
	/**
	 * 彻底删除邮件
	 */
	public void del(String id);
	
	/**
	 * 标记为已读
	 */
	
	public void reRead(String empid);
	
	/**
	 * 查看邮件
	 * @param empid
	 */
	public Information read(String empid);
	
public void qing(Employee emp);
	
	/**
	 * 还原
	 */
	public void huan(String empid);
}
