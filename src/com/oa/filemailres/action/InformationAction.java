package com.oa.filemailres.action;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
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
	private String qun;
	
	private int many;
	private int noreading;
	private int caogao;
	private int laji;
	private int all;
	private int pageNO;
	//判断查询未读条件 0群未读   1未读  4未读
 	private int state;
	private List<Information> infors;
	
	/**
	 * 初始化界面
	 */
	public String inite(){
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
		Map<String,Integer>  map = new HashMap<String,Integer>();
		map=inforService.initemail(emp);
		many=(Integer) map.get("many");
		noreading = (Integer) map.get("no");
		caogao = (Integer) map.get("caogao");
		laji = map.get("laji");
		return "success";
	}

	/**
	 * 模拟用户登录，由于没有整合
	 */
	public String login() {
		Employee emp = new Employee();
		
		HttpSession session = req.getSession();
		
		emp.setId(empid);
		session.setAttribute("emp",emp);
		return "login";
	}

	/**
	 * 存搞
	 * @return
	 */
	public String save() {
		
		HttpSession session = req.getSession();
		
		Employee emp = (Employee) session.getAttribute("emp");
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
			Employee emp = (Employee) session.getAttribute("emp");

		if("".equals(qun) || qun == null) {	
			Employee emp2 = new Employee();
			//根据ID 获取收件人对象
			emp2.setId(empid);
			
			information.setEmpSend(emp);
			information.setEmpReceiver(emp);
			information.setEmp(emp);
			
			inforService.sendemail(information,empid);
			
		}else {
			senderQun(empid,emp);
		}
		return "sender";
	}

	/**
	 * 群发
	 * @param str
	 * @param emp
	 */
	public void senderQun(String str,Employee emp) {
		information.setEmpSend(emp);
		inforService.senderQun(str,information);
		
	}
	
	/**
	 * 查询所有未读
	 * @return
	 */
	public String allNoRead(){
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("emp");
		Map<String,Integer>  map = new HashMap<String,Integer>();
		map=inforService.initemail(emp);
		if(pageNO < 1){
			pageNO = 1;
		}
		all=(int)map.get("all");
		many=(Integer) map.get("many");
		noreading = (Integer) map.get("no");
		all=(all%10==0)?all/10:all/10+1;
		if(pageNO > all){
			pageNO -= 1;
		}
		int page=(pageNO-1)*10;
		
		System.out.println(emp.getId()+page+state+"----------------------");
		infors = inforService.noreading(emp, state, page);
		while(infors.size()<10){
			infors.add(new Information());
		}
		return "allNoRead";
	}
	
	//删除消息
	public String delet(){
		
		System.out.println(empid);
		inforService.delete(empid);
		return "delete";
	}
	
	//彻底删除
	public String del(){
		
		inforService.del(empid);
		return "del";
	}
	//标记为已读
	public String reRead(){
		inforService.reRead(empid);
		return "reRead";
	}
	//读邮件
	public String read() {
		
		information = inforService.read(empid);
		return "read";
	}
	
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

	public int getCaogao() {
		return caogao;
	}

	public void setCaogao(int caogao) {
		this.caogao = caogao;
	}

	public int getLaji() {
		return laji;
	}

	public void setLaji(int laji) {
		this.laji = laji;
	}

	public String getQun() {
		return qun;
	}

	public void setQun(String qun) {
		this.qun = qun;
	}

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public List<Information> getInfors() {
		return infors;
	}

	public void setInfors(List<Information> infors) {
		this.infors = infors;
	}

	public int getPageNO() {
		return pageNO;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
