package com.oa.common;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;



/**
 * 所有Action都必须继承的类，封装了一些必要的方法和属性
 * @author sunxs
 *
 */
public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 8066576647777492904L;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	/**
	 * 获取当前会话的Session
	 * @return 当前会话的Session
	 */
	public HttpSession getSession(){
		return request.getSession();
	}
	
	/**
	 * 获取应用路径
	 */
	public String getPath(){
		return request.getContextPath();
	}

	/**
	 * 获取访问的完整基本路径
	 */
	public String getBasePath(){
		return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+getPath()+"/"; 
	}
	
	/**
	 * 获取调用的Action
	 */
	public String getActionPath(){
		return request.getServletPath();
	}
	
	/**
	 *获取访问者地址
	 */
	public String getRemoteAddress(){
		return request.getRemoteAddr();
	}
	
	/**
	 * 获取访问URI
	 */
	public String getUri(){
		return request.getRequestURI();
	}
	
	/**
	 * 将某个对象转换成json格式并发送到客户端
	 * @param response
	 * @param obj
	 * @throws Exception
	 */
	protected void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception{
		/*response.setContentType("application/json; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(toJsonString(obj));
		writer.close();
		response.flushBuffer();*/
		//TODO
	} 
	
	/**
	 * 输出文件流
	 * @param response
	 * @param file
	 * @param contentType 默认以image/jpg的格式发送
	 * @param buf 默认1024
	 * @throws Exception
	 */
	protected void outputStream(HttpServletResponse response, File file, String contentType, Integer buf) throws Exception {
		/*if( null == contentType || "".equals(contentType) ) {
			contentType = "image/jpg";
		}
		if( null == buf || buf == 0) {
			buf = 1024;
		}
		if( null != file && file.canRead() && file.isFile() ) {
			InputStream is = null;
			try {
				is = new FileInputStream(file);
				byte[] b = new byte[buf];
				OutputStream os = response.getOutputStream();
				int len = 0;
				while((len = is.read(b)) != -1 ) {
					os.write(b, 0, len);
				}
				os.close();
			} catch (Exception e) {
				throw new FileOperationException("文件读取错误");
			} finally {
				if( null != is ) {
					is.close();
				}
			}
		} else {
			throw new FileOperationException("文件不存在或不是文件");
		}*/
		//TODO 需要时在引入jar
	}
}
