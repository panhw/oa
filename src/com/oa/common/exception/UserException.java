package com.oa.common.exception;

/**
 * 用户行为异常，当用户操作异常时抛出
 * @author sunxs
 */
public class UserException extends RuntimeException {

	private static final long serialVersionUID = -1113886508024139831L;
	
	public  UserException(String msg){
		super(msg);
	}
	
	public UserException(String msg,Throwable cause){
		super(msg,cause);
	}
	

}
