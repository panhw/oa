package com.oa.filemailres.entity;

import java.sql.Date;

import com.oa.personal.entity.Employee;

/**
 *  消息
 * @author pan
 *
 */
public class Information {

	/**
	 * 消息ID
	 */
	private String id;
	/**
	 * 发件人ID
	 */
	private Employee empSend;
	/**
	 * 收件人ID
	 */
	private Employee empReceiver;
	/**
	 * 消息内容
	 */
	private String info;
	/**
	 * 是否是群邮件
	 */
	private int group;
	/**
	 * 发件时间
	 */
	private Date date;
	/**
	 * 邮件状态 已读未读
	 */
	private int status;
	/**
	 * 邮件状态 是否删除
	 */
	private int state;
	/**
	 * 扩展功能 未定义
	 */
	private String undifined;
	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Information(String id, Employee empSend, Employee empReceiver,
			String info, int group, Date date, int status, int state,
			String undifined) {
		super();
		this.id = id;
		this.empSend = empSend;
		this.empReceiver = empReceiver;
		this.info = info;
		this.group = group;
		this.date = date;
		this.status = status;
		this.state = state;
		this.undifined = undifined;
	}
	public Date getDate() {
		return date;
	}
	public Employee getEmpReceiver() {
		return empReceiver;
	}
	public Employee getEmpSend() {
		return empSend;
	}
	public int getGroup() {
		return group;
	}
	public String getId() {
		return id;
	}
	public String getInfo() {
		return info;
	}
	public int getState() {
		return state;
	}
	public int getStatus() {
		return status;
	}
	public String getUndifined() {
		return undifined;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setEmpReceiver(Employee empReceiver) {
		this.empReceiver = empReceiver;
	}
	public void setEmpSend(Employee empSend) {
		this.empSend = empSend;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setUndifined(String undifined) {
		this.undifined = undifined;
	}
	@Override
	public String toString() {
		return "Information [id=" + id + ", empSend=" + empSend
				+ ", empReceiver=" + empReceiver + ", info=" + info
				+ ", group=" + group + ", date=" + date + ", status=" + status
				+ ", state=" + state + ", undifined=" + undifined + "]";
	}
	
	
}
