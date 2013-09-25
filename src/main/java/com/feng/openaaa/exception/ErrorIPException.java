package com.feng.openaaa.exception;


/**
 * 
 * @author fengyouchao
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
