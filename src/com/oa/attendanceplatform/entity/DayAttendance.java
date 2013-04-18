package com.oa.attendanceplatform.entity;

import java.util.Date;

/**
 * 日考勤
 * @author sunxs
 */
public class DayAttendance {
	/** 逻辑id */
	private String id;
	/** 考勤状态（见AttendanceConts） */
	private String state;
	/** 考勤日期 */
	private Date date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
