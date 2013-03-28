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
	 * 查询草稿箱
	 * @return 
	 */
	public List<Information> caogao(int star,int step);
	

	/**
	 * 查询未读
	 * @return 
	 */
	public List<Information> noreading(int star,int step);
	
	/**
	 * 查询收件箱
	 * @return 
	 */
	public List<Information> receiver(int star,int step);
	
	/**
	 * 查询群邮箱
	 * @return 
	 */
	public List<Information> many(int star,int step);
	
	/**
	 * 查询垃圾箱
	 * @return 
	 */
	public List<Information> laji(int star,int step);
	
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


	public void senderQun(String str, Information information);
}
