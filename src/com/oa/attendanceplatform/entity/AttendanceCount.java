package com.oa.attendanceplatform.entity;

import java.util.Date;
import java.util.Map;

/**
 * 个人考勤统计
 * @author sunxs
 */
public class AttendanceCount {
	/** 雇员id */
	private String employeeId;
	/** 统计开始时间 */
	private Date startDate;
	/** 统计结束时间 */
	private Date endDate;
	/** 状态统计 */
	private Map<String,Integer> stateCount;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public Map<String, Integer> getStateCount() {
		return stateCount;
	}
	public void setStateCount(Map<String, Integer> stateCount) {
		this.stateCount = stateCount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
