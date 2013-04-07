package com.oa.filemailres.action;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;


import com.oa.common.TreeNodeUtils;
import com.oa.filemailres.dto.Node;
import com.oa.filemailres.entity.FileVO;
import com.oa.filemailres.service.FileService;
import com.oa.personal.entity.Employee;

import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport implements ServletRequestAware{

	private HttpServletRequest request;
	private String fatherid;
	private FileService fileService;
	private Employee emp;
	private String folderName;
	private String id;
	//分页 总页数
	private int all;
	//分页 当前页
	private int pageNO;
	
	
	public String execute(){
		
		List<FileVO> folders=fileService.findAllFolders(emp);
		List<Node> nodes = TreeNodeUtils.changeFileToNodes(folders);
		if (folders != null )request.setAttribute("folders", folders);
		if (nodes != null )request.setAttribute("nodes",nodes);		
		return "ini";
	}
	
	public String infile(){
		if (pageNO < 1) {
			pageNO = 1;
		}
		all = fileService.numAllFiles(emp);
		if (all == 0) all = 1;
		all = (all % 15 == 0) ? all / 15 : all / 15 + 1;
		if (pageNO > all) {
			pageNO -= 1;
		}
		int page = (pageNO - 1) * 15;
		List<FileVO> files=fileService.findAllFiles(emp,page);
		System.out.println(files);
		request.setAttribute("files",files);
		return "files";
	}
	public String test(){
		System.out.println("准备登陆++++++++++++++++");
		return "test";
	}
	
	public String login(){
		System.out.println(emp.getId()+"登陆++++++++++++++++");
		HttpSession session = request.getSession();
		session.setAttribute("emp", emp);
		return "login";
		
	}
	public String files(){
		if (pageNO < 1) {
			pageNO = 1;
		}
		all = fileService.numFiles(fatherid);
		if (all == 0) all = 1;
		all = (all % 15 == 0) ? all / 15 : all / 15 + 1;
		if (pageNO > all) {
			pageNO -= 1;
		}
		int page = (pageNO - 1) * 15;
		List<FileVO> files = fileService.findAllFiles(fatherid,page);
		request.setAttribute("files", files);
		return "files";
	}

	public String addFolder() throws UnsupportedEncodingException{		
		if (folderName == null) {
			folderName = "未命名";
		}else{
			folderName = new String(folderName.getBytes("ISO-8859-1"),"utf-8");
		}


		if (fatherid != null) {
			try {
				FileVO file = fileService.findById(fatherid);
				FileVO newFile = new FileVO();
				newFile.setFatherfile(file);
				newFile.setFileName(folderName);
				newFile.setUrl(file.getUrl() + "/" + folderName + "/");
				newFile.setState("1");
				newFile.setType("文件");
				newFile.setEmployee(emp);

				fileService.save(newFile);
				//System.out.println(newFile);
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			//没有文件夹的时候
			FileVO newFile = new FileVO();
			newFile.setFileName(folderName);
			newFile.setUrl("D:/" + emp.getName() + "/" + folderName + "/");
			
			newFile.setState("1");
			newFile.setType("文件");
			newFile.setEmployee(emp);
			fileService.save(newFile);
		}
			//System.out.println(newFile);
		return null;
	}
	
	public String share(){
		
		return null;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getFatherid() {
		return fatherid;
	}

	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public int getAll() {
		return all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	public int getPageNO() {
		return pageNO;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
