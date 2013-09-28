package com.feng.foa.model;


/**
 * 登陆结果类型。
 * @author fengyouchao
 * @version 1.0
 *
 */
public enum LoginResultType {
	/**
	 * 无法连接服务器。
	 */
	CANT_CONNECT_SERVER,
	
	/**
	 * OpenAAA API 版本错误。
	 */
	API_VERSION_ERROR,
	
	/**
	 * IP错误。
	 */
	ERROR_IP,
	
	/**
	 * 登陆成功。
	 */
	SUCCESS,
	
	/**
	 * 验证码错误。
	 */
	ERROR_TOKEN,
	
	/**
	 * 用户ID或密码错误。
	 */
	USER_ERROR

}
