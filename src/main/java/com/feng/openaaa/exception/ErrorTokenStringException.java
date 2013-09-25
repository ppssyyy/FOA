package com.feng.openaaa.exception;


/**
 * 
 * @author fengyouchao
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
