package com.oa.filemailres.service;

import java.util.List;
import java.util.Map;

import com.oa.filemailres.entity.Information;
import com.oa.personal.entity.Employee;

public interface InforService {

	/**
	 * 初始化话消息页面
	 * @return  no 为收未读 ，many为群未读 
	 */
	public Map<String, Integer> initemail(Employee emp);
	
	

	/**
	 * 查询所有未读
	 * @return 
	 */
	public List<Information> noreading(Employee emp,int state,int page);
	
	
	
	/**
	 * 查询收索内容
	 * @param str
	 * @param star
	 * @param step
	 * @return
	 */
	public List<Information> select(String str,int star,int step);
	
	/**
	 * 发邮件
	 * @param info
	 */
	public void sendemail(Information info,String empid);
	
	/**
	 * 存邮件
	 */
	public void save(Information info);


	/**
	 * 发群邮件
	 * @param str
	 * @param information
	 */
	public void senderQun(String str, Information information);
	
	//删除邮件
	public void delete(String empid);
	
	/**
	 * 彻底删除邮件
	 */
	public void del(String empid);
	
	/**
	 * 标记为已读
	 */
	
	public void reRead(String empid);
	
	/**
	 * 查看邮件
	 * @param empid
	 */
	public Information read(String empid);
	
	/**
	 * 清空
	 * @param emp
	 */
	public void qing(Employee emp);
	
	/**
	 * 还原
	 */
	public void huan(String empid);
}
