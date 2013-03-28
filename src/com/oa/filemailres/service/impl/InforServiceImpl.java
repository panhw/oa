package com.oa.filemailres.service.impl;

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

	public List<Information> noreading(int star, int step) {
		// TODO Auto-generated method stub
		return null;
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

	public void sendemail(Information info) {
		
		info.setState("1");
		info.setStatus("0");
		info.setManystate("3");
		info.setDate(new Date());
		//保存发件
		infordao.addInfo(info);
		System.out.println(info);
		
		Information infor = new Information();
		infor.setEmpReceiver(info.getEmpReceiver());
		infor.setEmp(info.getEmpReceiver());
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


	

}
