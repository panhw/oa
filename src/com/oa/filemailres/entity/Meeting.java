package com.oa.filemailres.entity;

import java.sql.Date;
import java.util.Set;

import com.oa.personal.entity.Employee;

/**
 * 会议管理
 * @author pan
 *
 */
public class Meeting {

	/**
	 * 会议ID
	 */
	private String id;
	/**
	 * 会议室
	 */
	private Room room;
	/**
	 * 会议发起人
	 */
	private Employee employee;
	/**
	 * 会议名称
	 */
	private String name;
	/**
	 * 开始时间
	 */
	private Date starDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	/**
	 * 扩展功能 未定义
	 */
	private String undefined;
	
	/**
	 * 开会人员
	 */
	private Set<Receive> recs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUndefined() {
		return undefined;
	}

	public void setUndefined(String undefined) {
		this.undefined = undefined;
	}

	public Set<Receive> getRecs() {
		return recs;
	}

	public void setRecs(Set<Receive> recs) {
		this.recs = recs;
	}

	@Override
	public String toString() {
		return "Meeting [id=" + id + ", room=" + room + ", employee="
				+ employee + ", name=" + name + ", starDate=" + starDate
				+ ", endDate=" + endDate + ", undefined=" + undefined
				+ ", recs=" + recs + "]";
	}

	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meeting(String id, Room room, Employee employee, String name,
			Date starDate, Date endDate, String undefined, Set<Receive> recs) {
		super();
		this.id = id;
		this.room = room;
		this.employee = employee;
		this.name = name;
		this.starDate = starDate;
		this.endDate = endDate;
		this.undefined = undefined;
		this.recs = recs;
	}
	
	
}
