package com.feng.foa.exception;


/**
 * 版本错误异常。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public class ErrorAPIVersionException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorAPIVersionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ErrorAPIVersionException(String message){
		super(message);
	}

}
