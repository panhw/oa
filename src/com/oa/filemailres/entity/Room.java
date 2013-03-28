package com.oa.filemailres.entity;

import java.util.Set;

import com.oa.personal.entity.Employee;

/**
 * 会议室管理
 * @author pan
 *
 */
public class Room {

	/**
	 * 会议室ID
	 */
	private String id;
	/**
	 * 会议室名字
	 */
	private String name;
	/**
	 * 会议室现有设备
	 */
	private String equipment;
	/**
	 * 会议室状态
	 */
	private String state;
	/**
	 * 会议室负责人
	 */
	private Employee employee;
	/**
	 * 扩展功能  为定义
	 */
	private String undefined;
	/**
	 * 会议室会议记录
	 */
	private Set<Meeting> meetings;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(String id, String name, String equipment, String state,
			Employee employee, String undefined, Set<Meeting> meetings) {
		super();
		this.id = id;
		this.name = name;
		this.equipment = equipment;
		this.state = state;
		this.employee = employee;
		this.undefined = undefined;
		this.meetings = meetings;
	}
	public Employee getEmployee() {
		return employee;
	}
	public String getEquipment() {
		return equipment;
	}
	public String getId() {
		return id;
	}
	public Set<Meeting> getMeetings() {
		return meetings;
	}
	public String getName() {
		return name;
	}
	public String getState() {
		return state;
	}
	public String getUndefined() {
		return undefined;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setUndefined(String undefined) {
		this.undefined = undefined;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", equipment=" + equipment
				+ ", state=" + state + ", employee=" + employee
				+ ", undefined=" + undefined + ", meetings=" + meetings + "]";
	}
	
	
	
}
