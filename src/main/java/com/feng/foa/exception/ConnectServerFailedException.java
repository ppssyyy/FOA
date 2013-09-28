package com.feng.foa.exception;


/**
 * 连接服务器失败异常。
 * 
 * @author fengyouchao
 * @version 1.0
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
