package com.oa.common.exception;

/**
 * Service层异常,service层发生异常时抛出
 * @author sunxs
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -1685989062175765333L;

	public  ServiceException(String msg){
		super(msg);
	}
	
	public ServiceException(String msg,Throwable cause){
		super(msg,cause);
	}
}
