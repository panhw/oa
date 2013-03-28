package com.oa.filemailres.action;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.oa.filemailres.entity.Information;
import com.oa.filemailres.service.InforService;
import com.oa.personal.entity.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.SimpleDate;

public class InformationAction extends ActionSupport implements ServletRequestAware {

	
	private InforService inforService;
	public HttpServletRequest req;
	private String empids;
	private Information information;
	private String empid;
	
	private int many;
	private int noreading;
	
	/**
	 * 初始化界面
	 */
	public String inite(){
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
		Map<String,Integer>  map = new HashMap<String,Integer>();
		map=inforService.initemail(emp);
		System.out.println(map);
		many=(Integer) map.get("many");
		noreading = (Integer) map.get("no");
		return "success";
	}

	/**
	 * 模拟用户登录，由于没有整合
	 */
	public String login() {
		Employee emp = new Employee();
		
		HttpSession session = req.getSession();
		
		emp.setId("abc");
		session.setAttribute("emp",emp);
		System.out.println(emp.getId()+"登陆成功");
		return "login";
	}

	/**
	 * 存搞
	 * @return
	 */
	public String save() {
		
		System.out.println("+++++++++++++++++++++++++++");
		HttpSession session = req.getSession();
		
		Employee emp = (Employee) session.getAttribute("emp");
		System.out.println(emp.getId()+"----------");
		information.setEmpSend(emp);
		information.setEmpReceiver(emp);
		information.setEmp(emp);
		inforService.save(information);
		return "save";
	}

	/**
	 * 发邮件
	 * @return
	 */
	public String sender() {
		
		HttpSession session = req.getSession();
		System.out.println("sender+++++++++++++++++");
		Employee emp = (Employee) session.getAttribute("emp");
		System.out.println(emp.getId()+"---------------");
		
		Employee emp2 = emp;
		//根据ID 获取收件人对象
		//emp2.setId("abc");
		
		information.setEmpSend(emp);
		information.setEmpReceiver(emp);
		information.setEmp(emp);
		
		inforService.sendemail(information);
		return "sender";
		
	}

	public String allNoRead(){
		
		
		return "allNoRead";
	}
	/**
	 * 查询草稿箱
	 * @return
	 */
	public InforService getInforService() {
		return inforService;
	}

	public void setInforService(InforService inforService) {
		this.inforService = inforService;
	}

	public String getEmpids() {
		return empids;
	}

	public void setEmpids(String empids) {
		this.empids = empids;
	}

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public int getMany() {
		return many;
	}

	public void setMany(int many) {
		this.many = many;
	}

	public int getNoreading() {
		return noreading;
	}

	public void setNoreading(int noreading) {
		this.noreading = noreading;
	}

	public void setServletRequest(HttpServletRequest req) {
		this.req=req;
	}

	
	
}
