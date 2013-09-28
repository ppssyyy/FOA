package com.feng.foa.exception;


/**
 * 验证码错误异常。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public class ErrorTokenStringException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorTokenStringException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ErrorTokenStringException(String message){
		super(message);
	}

}
