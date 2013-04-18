package com.oa.personal.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组，有时候一些人员可能会聚合为一个组（区别于人员组合成部门，一个人只能属于一个部门但可以属于多个组）
 * @author sunxs
 *
 */
public class Group {
	/** id */
	private int id;
	
	/** 组名 */
	private String name;
	/** 成员 */
	private List<Employee> members=new ArrayList<Employee>();;
	/** 组内官员职位，保存格式：<职位,雇员> */
	private Map<Post,Employee> posts=new HashMap<Post,Employee>();
	
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
	public List<Employee> getMembers() {
		return members;
	}
	public void setMembers(List<Employee> members) {
		this.members = members;
	}
	public Map<Post, Employee> getPosts() {
		return posts;
	}
	public void setPosts(Map<Post, Employee> posts) {
		this.posts = posts;
	}
}
