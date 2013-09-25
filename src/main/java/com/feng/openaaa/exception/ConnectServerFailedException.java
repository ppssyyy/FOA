package com.feng.openaaa.exception;


/**
 * 
 * @author fengyouchao
 *
 */
public class ConnectServerFailedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectServerFailedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ConnectServerFailedException(String message){
		super(message);
	}



}
