package com.feng.foa.service;

import com.feng.foa.exception.AuthenticationException;
import com.feng.foa.exception.ConnectServerFailedException;
import com.feng.foa.exception.ErrorAPIVersionException;
import com.feng.foa.exception.ErrorIPException;
import com.feng.foa.exception.ErrorTokenStringException;
import com.feng.foa.exception.UnknownException;
import com.feng.foa.model.BasicInfomation;
import com.feng.foa.model.LoginInfomation;


/**
 * OpenAAA服务接口，定义了基本的服务。
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface OpenAAAService {
	
	/**
	 * 获取验证图片。
	 * 
	 * @return 验证图片的byte[]数组。
	 * @throws ConnectServerFailedException
	 */
	byte[] getTokenPicture() throws ConnectServerFailedException;
	
	/**
	 * 登录。
	 * 
	 * @param loginInfomation	用户信息。
	 * @throws AuthenticationException 验证异常。当用户名或密码错误时将抛出此异常。
	 * @throws ConnectServerFailedException 无法连接服务器异常。
	 * @throws ErrorTokenStringException 验证码错误异常。
	 * @throws ErrorAPIVersionException OpenAAA API版本错误异常。
	 * @throws ErrorIPException IP地址错误异常。
	 * @see AuthenticationException
	 * @see ConnectServerFailedException
	 * @see ErrorTokenStringException
	 * @see ErrorAPIVersionException
	 * @see ErrorIPException
	 * 
	 */
	void login(LoginInfomation loginInfomation) throws AuthenticationException,
	ConnectServerFailedException,ErrorTokenStringException,
	ErrorAPIVersionException,ErrorIPException;
	
	
	/**
	 * 注销。
	 * @param id 用户ID。
	 * @param tokenString 验证码。
	 * @throws ConnectServerFailedException 无法连接服务器异常。
	 * @throws ErrorTokenStringException 验证码错误异常。
	 * @see ConnectServerFailedException
	 * @see ErrorTokenStringException
	 */
	void logout(String id,String tokenString) throws ConnectServerFailedException
		,ErrorTokenStringException;
	
	/**
	 * 维持会话。
	 * @param id 用户ID。
	 * @param tokenString 验证码。
	 * @throws ConnectServerFailedException 无法连接服务器异常。
	 * @throws AuthenticationException 验证异常。当用户名或密码错误时将抛出此异常。
	 * @throws ErrorTokenStringException 验证码错误异常。
	 * @throws UnknownException 未知异常。
	 * @see ConnectServerFailedException
	 * @see AuthenticationException
	 * @see ErrorTokenStringException
	 * @see UnknownException
	 */
	void keepSession(String id, String tokenString) throws ConnectServerFailedException, 
	AuthenticationException, ErrorTokenStringException, UnknownException;
	
	
	/**
	 * 判断是否需要更新。
	 * @return 需要更新返回true。
	 * @throws ConnectServerFailedException
	 */
	boolean isAPINeedUpdate() throws ConnectServerFailedException;
	
	/**
	 * 初始化方法。
	 * @throws ConnectServerFailedException
	 */
	void initOpenAAASoap() throws ConnectServerFailedException;
	
	/**
	 * 获取IP地址。
	 * @return {@link String}类型的IP地址。
	 * @throws ConnectServerFailedException
	 */
	String getIpAddress() throws ConnectServerFailedException;
	
	/**
	 * 获取基本信息。
	 * @return {@link BasicInfomation}对象。表示基本信息。
	 * @throws AuthenticationException 
	 */
	BasicInfomation getBasicInformation() throws AuthenticationException;
	
	/**
	 * 判断是用户是否登陆。
	 * 
	 * @return 已经登录返回true。
	 */
	boolean isLogin();

}
