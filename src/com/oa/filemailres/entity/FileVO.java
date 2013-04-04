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
	 * 父节点
	 */
	private FileVO fatherfile;
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
	 *  文件状态 1 正常 2 共享 3删除
	 */
	private int state;
	
	/**
	 * 文件还是文件夹0是文件夹 一是文件
	 */
	private String type;
	/**
	 *  扩展部分 未定义
	 */
	private String undefined;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public FileVO getFatherfile() {
		return fatherfile;
	}
	public void setFatherfile(FileVO fatherfile) {
		this.fatherfile = fatherfile;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUndefined() {
		return undefined;
	}
	public void setUndefined(String undefined) {
		this.undefined = undefined;
	}
	@Override
	public String toString() {
		return "FileVO [id=" + id + ", url=" + url + ", date=" + date
				+ ", fileName=" + fileName + ", state=" + state + ", type="
				+ type + ", undefined=" + undefined + "]";
	}
}
