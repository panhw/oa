package com.oa.personal.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工所属部门实体
 * @author sunxs
 */
public class Department {

	/** 部门的ID号 */
	private int id;
	/** 部门名称 */
	private String name;
	/** 部门中的员工 */
	private List<Employee> employees = new ArrayList<Employee>();

	public Department(){}
	
	/**
	 * 构造一个部门
	 * @param id	部门的id号
	 */
	public Department(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
