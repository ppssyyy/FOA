package com.feng.openaaa.exception;


/**
 * 
 * @author fengyouchao
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
