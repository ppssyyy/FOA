package com.feng.openaaa.exception;

/**
 * 
 * @author fengyouchao
 *
 */
public class LoadTokenPictureException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoadTokenPictureException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public LoadTokenPictureException(String message){
		super(message);
	}

}
