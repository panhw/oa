package com.oa.filemailres.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpAction {

	private File headImage;//实际上传文件(与form表单对应)

	private String headImageFileName;//上传文件名
	private String headImageContentType;//文件的内容类型

	private String fileDesc;// 上传文件时的备注
	private String u;
	public String add() throws IOException {
		

		String flag = "success";
		System.out.println("进来了"+headImage);
        // 获得当前应用路径
        String path = ServletActionContext.getServletContext().getRealPath(
                "/Images/headImage");
        if (headImage != null) {
            File savefile = new File(new File(path), headImageFileName);
            System.out.println(savefile.getPath());
            // 判断路径是否存在
            if (!savefile.getParentFile().exists()) {
                // 如果不存在就创建一个
            	//savefile.createNewFile();
                savefile.getParentFile().mkdirs();
                
            }
            System.out.println(savefile);
            u = savefile.getPath();
            
            // 通过FileUtils进行文件复制操作
            try {
                FileUtils.copyFile(headImage, savefile);
            } catch (IOException e) {
                flag = "error";
                e.printStackTrace();
            }
        }
        return flag;
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

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
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
	
	
}
