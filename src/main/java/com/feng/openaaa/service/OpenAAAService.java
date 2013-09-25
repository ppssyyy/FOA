package com.feng.openaaa.service;

import com.feng.openaaa.exception.AuthenticationException;
import com.feng.openaaa.exception.ConnectServerFailedException;
import com.feng.openaaa.exception.ErrorAPIVersionException;
import com.feng.openaaa.exception.ErrorIPException;
import com.feng.openaaa.exception.ErrorTokenStringException;
import com.feng.openaaa.exception.UnknownException;
import com.feng.openaaa.model.BasicInfomation;
import com.feng.openaaa.model.LoginInfomation;


/**
 * 
 * @author fengyouchao
 *
 */
public interface OpenAAAService {
	
	byte[] getTokenPicture() throws ConnectServerFailedException;
	
	void login(LoginInfomation loginInfomation) throws AuthenticationException,
	ConnectServerFailedException,ErrorTokenStringException,ErrorTokenStringException,
	ErrorAPIVersionException,ErrorIPException;
	
	void logout(String id,String tokenString) throws ConnectServerFailedException
		,ErrorTokenStringException;
	
	void keepSession(String id, String tokenString) throws ConnectServerFailedException, 
	AuthenticationException, ErrorTokenStringException, UnknownException;
	
	boolean isNeedUpdate() throws ConnectServerFailedException;
	
	void initOpenAAASoap() throws ConnectServerFailedException;
	
	String getIpAddress() throws ConnectServerFailedException;
	
	BasicInfomation getBasicInformation() throws AuthenticationException;
	
	boolean isLogin();

}
