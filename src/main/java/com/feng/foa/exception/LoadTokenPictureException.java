package com.feng.foa.exception;

/**
 * 下载验证图片异常。
 * 
 * @author fengyouchao
 * @version 1.0
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
