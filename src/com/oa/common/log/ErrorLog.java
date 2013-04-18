package com.oa.common.log;

import java.util.Date;

/**
 * 系统错误日志
 * @author sunxs
 */
public class ErrorLog {
	/** 逻辑id */
	private String id;
	/** 日志记录时间 */
	private Date logTime;
	/** 错误级别 */
	private String errorLevel;
	/** 错误信息 */
	private String errorMsg;
	/** 错误类型 */
	private String errorType;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public String getErrorLevel() {
		return errorLevel;
	}
	public void setErrorLevel(String errorLevel) {
		this.errorLevel = errorLevel;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorType() {
		return errorType;
	}
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	
}
