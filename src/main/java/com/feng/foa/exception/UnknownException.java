package com.feng.foa.exception;


/**
 * 未知异常。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public class UnknownException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UnknownException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnknownException(String message){
		super(message);
	}

}
