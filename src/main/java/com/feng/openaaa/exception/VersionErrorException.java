package com.feng.openaaa.exception;


/**
 * 
 * @author fengyouchao
 *
 */
public class VersionErrorException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public VersionErrorException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public VersionErrorException(String message){
		super(message);
	}

}
