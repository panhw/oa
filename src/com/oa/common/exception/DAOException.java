package com.oa.common.exception;

/**
 * DAO层异常
 * @author sunxs
 */
public class DAOException extends RuntimeException {

	private static final long serialVersionUID = -8731671236961810628L;

	public  DAOException(String msg){
		super(msg);
	}
	
	public DAOException(String msg,Throwable cause){
		super(msg,cause);
	}
}
