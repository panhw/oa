package com.oa.filemailres.entity;

import java.sql.Date;

import com.oa.personal.entity.Employee;

/**
 * 文件共享
 * @author pan
 *
 */
public class FileVO {

	/**
	 * 文件ID
	 */
	private String id;
	/**
	 * 此文件用户ID
	 */
	private Employee employee;
	/**
	 * 文件地址
	 */
	private String url;
	/**
	 * 修改时间
	 */
	private Date date;
	/**
	 *  文件名
	 */
	private String fileName;
	/**
	 *  文件状态
	 */
	private int state;
	/**
	 *  文件是否共享
	 */
	private int share;
	/**
	 *  扩展部分 未定义
	 */
	private String undefined;
	public FileVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileVO(String id, Employee employee, String url, Date date,
			String fileName, int state, int share, String undefined) {
		super();
		this.id = id;
		this.employee = employee;
		this.url = url;
		this.date = date;
		this.fileName = fileName;
		this.state = state;
		this.share = share;
		this.undefined = undefined;
	}
	public Date getDate() {
		return date;
	}
	public Employee getEmployee() {
		return employee;
	}
	public String getFileName() {
		return fileName;
	}
	public String getId() {
		return id;
	}
	public int getShare() {
		return share;
	}
	public int getState() {
		return state;
	}
	public String getUndefined() {
		return undefined;
	}
	public String getUrl() {
		return url;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setUndefined(String undefined) {
		this.undefined = undefined;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "File [id=" + id + ", employee=" + employee + ", url=" + url
				+ ", date=" + date + ", fileName=" + fileName + ", state="
				+ state + ", share=" + share + ", undefined=" + undefined + "]";
	}
	
	
	
}
