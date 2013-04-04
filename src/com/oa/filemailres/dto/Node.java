package com.oa.filemailres.dto;

import java.io.Serializable;

public class Node implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7675206249142645110L;
	/*
	   tree.add(id,pid,name,url,title,target,icon,iconOpen,open); 
	   d.add('${n.id}','${n.pid}','${n.name}','${n.url}','${n.title}','${n.target}','${n.icon}','${n.iconOpen}','${n.open}');
                    id        ：节点自身的id 
                    pid       ：节点的父节点的id 
                    name      ：节点显示在页面上的名称 
                    url       ：节点的链接地址 
                    title     ：鼠标放在节点上所出现的提示信息 
                    target    ：节点链接所打开的目标frame（如框架目标mainFrame或是_blank,_self之类） 
                    icon      ：节点关闭时的显示图片的路径 
                    iconOpen  ：节点打开时的显示图片的路径 
                    open      ：布尔型，节点是否打开（默认为false） 
	 */
	private String id="";
	private String pid="";
	private String name="";
	private String url="";
	private String title="";
	private String target="";
	private String icon="";
	private String iconOpen="";
	private boolean open;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconOpen() {
		return iconOpen;
	}
	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Node(String id, String pid, String name, String url, String title,
			String target, String icon, String iconOpen, boolean open) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.url = url;
		this.title = title;
		this.target = target;
		this.icon = icon;
		this.iconOpen = iconOpen;
		this.open = open;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", pid=" + pid + ", name=" + name + ", url="
				+ url + ", title=" + title + ", target=" + target + ", icon="
				+ icon + ", iconOpen=" + iconOpen + ", open=" + open + "]\n";
	}


	
	
	

}
