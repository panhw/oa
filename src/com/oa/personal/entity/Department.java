package com.oa.personal.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	/** 职位,Map<职位,雇员> */
	private Map<Post,Employee> posts=new HashMap<Post,Employee>();

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

	public Map<Post, Employee> getPosts() {
		return posts;
	}

	public void setPosts(Map<Post, Employee> posts) {
		this.posts = posts;
	}

}
