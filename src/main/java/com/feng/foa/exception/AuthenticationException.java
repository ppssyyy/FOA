package com.feng.foa.exception;


/**
 * 用户身份验证异常。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public class AuthenticationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AuthenticationException(String message){
		super(message);
	}

}
