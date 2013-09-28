package com.feng.foa.exception;


/**
 * IP错误异常。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public class ErrorIPException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorIPException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ErrorIPException(String message){
		super(message);
	}

}
