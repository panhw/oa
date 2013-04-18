package com.oa.attendanceplatform.entity;

import java.util.Date;

/**
 * 一次签到
 * @author sunxs
 */
public class OnceSiginIn {
	/** 逻辑id */
	private String id;
	/** 用户id */
	private String employeeId;
	/** 签到时间 */
	private Date siginInTime;
	/** 签到类型（常量，见AttendanceConsts） */
	private String siginType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Date getSiginInTime() {
		return siginInTime;
	}
	public void setSiginInTime(Date siginInTime) {
		this.siginInTime = siginInTime;
	}
	public String getSiginType() {
		return siginType;
	}
	public void setSiginType(String siginType) {
		this.siginType = siginType;
	}
}
