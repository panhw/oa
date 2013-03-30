package com.oa.filemailres.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.dialect.InformixDialect;

import com.oa.filemailres.dao.inforDao;
import com.oa.filemailres.entity.Information;
import com.oa.filemailres.service.InforService;
import com.oa.personal.entity.Employee;
import com.oa.personal.service.EmployeeService;

public class InforServiceImpl implements InforService {

	
	private inforDao infordao;

	


	public Map<String, Integer> initemail(Employee emp) {
		/*String sql="from Information i where i.manystate='0' and i.status='1' and i.emp.id="+"'"+emp.getId()+"'";
		List<Information> infos = infordao.list(sql);	
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("many", infos.size());
		String sql2="from Information i where i.manystate='1' and i.status='1' and i.emp.id="+"'"+emp.getId()+"'";
		infos = infordao.list(sql2);
		map.put("no", infos.size());
		String sql3 = "select count(o) from Information i where i.manystate='3' and i.emp.id="+"'"+emp.getId()+"'";
		int c = infordao.list(sql3);*/
		return infordao.initeData(emp);
	}

	public List<Information> caogao(int star, int step) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Information> noreading(Employee emp,int state, int page) {
		
		List<Information> list = infordao.noreading(emp, state, page);
		
		return list;
	}

	public List<Information> receiver(int star, int step) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Information> many(int star, int step) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Information> laji(int star, int step) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Information> select(String str, int star, int step) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendemail(Information info,String empid) {
		
		info.setState("1");
		info.setStatus("0");
		info.setManystate("3");
		info.setDate(new Date());
		//保存发件
		infordao.addInfo(info);
		
		System.out.println(info);
		String ids[] = empid.split(";");
		for(int i=0;i<ids.length;i++){
			if(ids[i] !=null){
				Employee emp = new Employee();
				emp.setId(ids[i]);
				Information infor = new Information();
				infor.setEmpReceiver(emp);
				infor.setEmp(emp);
				infor.setEmpSend(info.getEmpSend());
				infor.setInfo(info.getInfo());
				infor.setTopical(info.getTopical());
				infor.setDate(info.getDate());
				infor.setState("1");
				infor.setStatus("1");
				infor.setManystate("1");
				//保存收件
				infordao.addInfo(infor);
			}
		}
		
	}

	public void save(Information info) {
		info.setState("1");
		info.setStatus("0");
		info.setManystate("2");
		info.setDate(new Date());
		
		infordao.addInfo(info);
		
	}

	public inforDao getInfordao() {
		return infordao;
	}

	public void setInfordao(inforDao infordao) {
		this.infordao = infordao;
	}

	public void senderQun(String str, Information information) {
		
		information.setDate(new Date());
		//根据 部门名称去 emps 
		List<Employee> emps = new ArrayList<Employee>();
		/*Employee e1 =new Employee();
		e1.setId("abc");
		emps.add(e1);*/
		Employee e2 =new Employee();
		e2.setId("123");
		emps.add(e2);
		Employee e3 =new Employee();
		e3.setId("234");
		emps.add(e3);
		for (Employee e : emps){
			Information info  = new Information();
			info.setEmp(e);
			info.setEmpReceiver(e);
			info.setEmpSend(information.getEmpSend());
			info.setInfo(information.getInfo());
			info.setState("1");
			info.setStatus("1");
			info.setManystate("0");
			info.setDate(information.getDate());
			info.setTopical(information.getTopical());
			info.setUndifined(str); 
			infordao.addInfo(info);
		}
	}

	public void delete(String empid) {
		String ids[] = empid.split(";");
		for(String id:ids){
			if(id !=null){
				infordao.delete(id);
			}	
		}
	}

	public void del(String empid) {
		String ids[] = empid.split(";");
		for(String id:ids){
			if(id !=null){
				infordao.del(id);
			}
		}
	}

	public void reRead(String empid) {
		String ids[] = empid.split(";");
		for(String id:ids){
			if(id !=null){
				infordao.reRead(id);
			}
		}
	}

	public Information read(String empid) {
		return infordao.read(empid);
	}


	

}
