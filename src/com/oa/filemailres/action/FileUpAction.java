package com.oa.filemailres.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.oa.filemailres.entity.FileVO;
import com.oa.filemailres.service.FileService;
import com.oa.personal.entity.Employee;

public class FileUpAction implements SessionAware {

	private File headImage;//实际上传文件(与form表单对应)

	private String headImageFileName;//上传文件名
	private String headImageContentType;//文件的内容类型
	private Map session;
	private FileService fileService;
	private String fatherid;// 上传文件时的备注
	private String u;
	
	
	public String add() throws IOException {
		Employee emp = (Employee) session.get("emp");

		String flag = "success";
        String path = "D:/oaresource/"+emp.getName();
        if (headImage != null) {
            File savefile = new File(new File(path), headImageFileName);
            System.out.println(savefile.getPath());
            if (!savefile.getParentFile().exists()) {
            	//savefile.createNewFile();
                savefile.getParentFile().mkdirs();                
            }
            System.out.println(savefile);
            u = savefile.getPath();
            try {
                FileUtils.copyFile(headImage, savefile);
                saveFile(emp,savefile);
            } catch (IOException e) {
                flag = "error";
                e.printStackTrace();
            }
        }
        return flag;
	}

	public void saveFile(Employee emp,File file){
		FileVO fvo  = new FileVO();
		fvo.setDate(new Date());
		fvo.setEmployee(emp);
		fvo.setFileName(file.getName());
		fvo.setState("1");
		fvo.setType("1");
		fvo.setUrl(file.getPath());
		FileVO father = fileService.findById(fatherid);
		if (father != null) fvo.setFatherfile(father);
		
		fileService.save(fvo);
		System.out.println(fvo);
		
	}
	public File getHeadImage() {
		return headImage;
	}

	public void setHeadImage(File headImage) {
		this.headImage = headImage;
	}

	public String getHeadImageFileName() {
		return headImageFileName;
	}

	public void setHeadImageFileName(String headImageFileName) {
		this.headImageFileName = headImageFileName;
	}

	public String getHeadImageContentType() {
		return headImageContentType;
	}

	public void setHeadImageContentType(String headImageContentType) {
		this.headImageContentType = headImageContentType;
	}
	public String getFatherid() {
		return fatherid;
	}

	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}

	public String execute() {
        String flag = "success";
        return flag;
    }

	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	
}
