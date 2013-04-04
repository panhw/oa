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
	private Employee emp = new Employee();
	private String folderName;
	
	public String execute(){
		
		List<FileVO> folders=fileService.findAllFolders(emp);
		List<FileVO> files =null;
		if(folders!=null&&folders.size()!=0){
			files=fileService.findAllFiles(folders.get(0).getId());
		}
		List<Node> nodes = TreeNodeUtils.changeFileToNodes(folders);
		request.setAttribute("folders", folders);
		request.setAttribute("nodes",nodes);
		request.setAttribute("files",files);
		return null;
	}
	
	public String test(){
		
		return "test";
	}
	
	public String login(){
		HttpSession session = request.getSession();
		session.setAttribute("emp", emp);
		return "login";
		
	}
	public String files(){
		List<FileVO> files = fileService.findAllFiles(fatherid);
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
				newFile.setState(1);
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
			
			newFile.setState(1);
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
	
	
}
