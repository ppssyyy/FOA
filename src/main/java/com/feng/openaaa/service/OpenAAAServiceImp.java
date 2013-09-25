package com.feng.openaaa.service;

import org.apache.log4j.Logger;

import cn.edu.nsu.aaa.LoginResultInfo;
import cn.edu.nsu.aaa.OpenAAA;
import cn.edu.nsu.aaa.OpenAAASoap;

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
public class OpenAAAServiceImp implements OpenAAAService{
	
	private final static Logger log = Logger.getLogger(OpenAAAServiceImp.class);

	private static OpenAAASoap openAAASoap;

	private static BasicInfomation basicInfomation;


	@Override
	public byte[] getTokenPicture() throws ConnectServerFailedException {
		initOpenAAASoap();
		return openAAASoap.getTokenPictureBytes();
	}

	@Override
	public void login(LoginInfomation info)
			throws  AuthenticationException, ConnectServerFailedException,
					ErrorTokenStringException, ErrorTokenStringException,
					ErrorAPIVersionException, ErrorIPException {

		initOpenAAASoap();
		LoginResultInfo result = null;
		try{
			result = openAAASoap.login(info.getUserId(), info.getPassword(),
					info.getIpAddress(), info.getAPIVersion(), info.getTokenString());
		}catch(Exception e){
			
			throw new ConnectServerFailedException("Can't connect server");
		}

		log.debug("login result message:"+result.getMessage());
		
		//检测是否IP错误
		if(result.isIsIPInvalid()){
			
			throw new ErrorIPException("wrong ip address");
			
		}
		//检测是否验证码错误
		else if(result.getMessage().equals("Token输入不正确.") ||
				 result.getMessage().equals("输入的Token过短.") ){
			throw new ErrorTokenStringException("error token");
		}

		//检测是否用户错误
		else if(result.isIsIDPWWrong()){
			throw new AuthenticationException("user's id or password is incorrect");
		}
		
		basicInfomation = new BasicInfomation(result);
	}


	@Override
	public void logout(String id,String tokenString) throws ConnectServerFailedException
		,ErrorTokenStringException {
		openAAASoap.logout(id, tokenString);
		basicInfomation = null;
	}

	@Override
	public void keepSession(String id,String tokenString) throws ConnectServerFailedException,
	AuthenticationException, ErrorTokenStringException, UnknownException {
		
		String result = null;
		
		try{
			result = openAAASoap.keepSession(id, tokenString);
			log.debug("keepSession result:"+result);
		}catch(Exception e){
			throw new ConnectServerFailedException("can't connect server",e);
		}
		if(result.equals("Token输入不正确.") || result.equals("输入的Token过短.")){
			throw new ErrorTokenStringException("error token");
		}
		else if(result.equals("无效会话")){
			throw new AuthenticationException("user hasn't login");		
		}
		else if(!result.equals("True")){
			throw new UnknownException("unknown exception");
		}
	}

	@Override
	public boolean isNeedUpdate() throws ConnectServerFailedException {

		LoginResultInfo result = null;
		try{
			initOpenAAASoap();
			result = testLogin();
		}catch(Exception e){
			throw new ConnectServerFailedException("Can't connect server");
		}
		return result.isIsNeedUpdate();
	}

	@Override
	public void initOpenAAASoap() throws ConnectServerFailedException {
		if( openAAASoap == null ){
			try{
			openAAASoap = new OpenAAA().getOpenAAASoap();
			}catch(Exception e){
				openAAASoap = null;
				throw new ConnectServerFailedException("Can't connect server");
			}
		}
	}

	@Override
	public String getIpAddress() throws ConnectServerFailedException {
		LoginResultInfo loginResultInfo = null;
		try{
			loginResultInfo = testLogin();
		}catch(Exception e){
			throw new ConnectServerFailedException("Can't connect server",e);
		}
		String ip = loginResultInfo.getMessage().replace("客户端IP与实际IP不符, 你的实际IP为:", "").trim();
		return ip;
	}

	@Override
	public BasicInfomation getBasicInformation() throws AuthenticationException {
		return basicInfomation;
	}

	/**
	 * test login to get some information from server.
	 * @return
	 */
	private LoginResultInfo testLogin(){

		LoginInfomation info = new LoginInfomation();
		LoginResultInfo result = openAAASoap.login(info.getUserId(), info.getPassword(),
				info.getIpAddress(), info.getAPIVersion(), info.getTokenString());
		return result;

	}

	@Override
	public boolean isLogin() {
		if(basicInfomation == null || !basicInfomation.isLogin()){
			return false;
		}else{
			return true;
		}
	}






}
