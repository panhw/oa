package com.oa.filemailres.entity;

import com.oa.personal.entity.Employee;

/**
 * 开会人员记录
 * 
 * @author pan
 * 
 */
public class Receive {

	/**
	 * 为了方便存取操作 自定义表ID
	 */
	private String id;
	/**
	 * 记录为那次会议的人员
	 */
	private Meeting meeting;
	/**
	 * 人员
	 */
	private Employee employee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Receive [id=" + id + ", meeting=" + meeting + ", employee="
				+ employee + "]";
	}

	public Receive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receive(String id, Meeting meeting, Employee employee) {
		super();
		this.id = id;
		this.meeting = meeting;
		this.employee = employee;
	}

}
