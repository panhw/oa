package com.oa.common.exception;

/**
 * Action层异常，action层发生异常时抛出
 * @author sunxs
 */
public class ActionException extends RuntimeException {

	private static final long serialVersionUID = 7136667539713650908L;
	
	public  ActionException(String msg){
		super(msg);
	}
	
	public ActionException(String msg,Throwable cause){
		super(msg,cause);
	}
	
}
