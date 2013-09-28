package com.feng.foa.model;

/**
 * 定义了维护会话的反馈类型。
 * 
 * @author fengyouchao
 *
 */
public enum KeepSessionType {
	/**
	 * 无效会话。
	 */
	NO_SESSION,
	/**
	 * 验证码错误。
	 */
	TOKEN_ERROR, 
	/**
	 * 无法连接服务器(网络错误)。表示当前KeepSession任务因为问题无法连接服务器。
	 */
	CANT_CONNECT_SERVER, 
	/**
	 * 未知错误。表示当前KeepSession任务遇到未知错误。
	 */
	UNKNOW_ERROR,
	/**
	 * 成功。表示当前KeepSession任务正常执行。
	 */
	SUCCESS
}
