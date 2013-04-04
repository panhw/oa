package com.oa.filemailres.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;



import com.opensymphony.xwork2.ActionSupport;

public class FileLoadAction  extends ActionSupport implements ServletResponseAware{

       private HttpServletResponse response;
        private String fileName;
        private String name;
       
        public void setFileName(String fileName) throws UnsupportedEncodingException {
                this.fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
        }
        public InputStream getInputStream() throws FileNotFoundException {
        	System.out.println(fileName);
             //   return ServletActionContext.getServletContext().getResourceAsStream("/" + fileName);
        	
        	return new FileInputStream(fileName);
        }
       
        public String execute(){
        	response.setCharacterEncoding("utf-8");
        	File file = new File(fileName);
        	name=file.getName();
        	System.out.println(name);
        	System.out.println(fileName);
        	
            return "success";
        }
		public String getName() throws UnsupportedEncodingException {
			return new String(name.getBytes("gb2312"),"iso-8859-1");
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFileName() {
			return name;
		}
		public void setServletResponse(HttpServletResponse response) {
			this.response =  response;
		}
        
        

}
