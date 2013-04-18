package com.oa.workflow.leave.entity;

import java.util.Date;

/**
 * 请假实体类
 * @author sunxs
 */
public class Leave {
	private String id;
	/** 用户id */
	private String employeeId;
	/** 请假类型[事假，病假，公休，婚假，产假。。。] */
	private String leaveType;
	/** 请假开始时间 */
	private Date startDate;
	/** 请假结束时间 */
	private Date endDate;
	/** 实际开始时间 */
	private Date actualStartDate;
	/** 实际结束时间 */
	private Date actualEndDate;
	/** 请假原因 */
	private String reason;
	
	//以下为处理流程相关属性
	/** 处理流程实例id */
	private String processInstanceId;
	/** 当前状态 */
	private String currentState; 
	/** 当前节点 */
	private String currentNode;
	
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
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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
	public Date getActualStartDate() {
		return actualStartDate;
	}
	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}
	public Date getActualEndDate() {
		return actualEndDate;
	}
	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	public String getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}
	
}
