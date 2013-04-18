package com.oa.workflow.leave.entity;

import java.util.Date;

import com.oa.personal.entity.Employee;

/**
 * 出差实体类
 * @author sunxs
 */
public class BusinessTrip {
	private String id;
	/** 雇员 */
	private Employee employee;
	/** 出差开始日期 */
	private Date startDate;
	/** 出差结束日期 */
	private Date endDate;
	/** 出差地点 */
	private String location;
	/** 原因 */
	private String reason;
	/** 出差计划 */
	private String plan;
	/** 出差预算 */
	private Double budget;
	/** 出差实际开始日期 */
	private Date actualStartDate;
	/** 出差实际结束日期 */
	private Date actualEndDate;
	
	// 以下为处理流程相关属性
	/** 处理流程实例id */
	private String processInstanceId;
	/** 当前状态 */
	private String currentState;
	/** 当前节点 */
	private String currentNode;
	
}
