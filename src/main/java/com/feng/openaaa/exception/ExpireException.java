package com.feng.openaaa.exception;


/**
 * 
 * @author fengyouchao
 *
 */
public class ExpireException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ExpireException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ExpireException(String message){
		super(message);
	}

}
