package com.feng.openaaa.newtask;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.feng.openaaa.exception.AuthenticationException;
import com.feng.openaaa.exception.ConnectServerFailedException;
import com.feng.openaaa.exception.ErrorIPException;
import com.feng.openaaa.exception.ErrorTokenStringException;
import com.feng.openaaa.model.LoginInfomation;
import com.feng.openaaa.model.LoginResultType;
import com.feng.openaaa.newtask.listener.LoginTaskListener;
import com.feng.openaaa.newtask.observable.LoginTaskObservable;
import com.feng.openaaa.service.OpenAAAService;

import javafx.concurrent.Task;


/**
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 *
 */
public class LoginTask extends Task<Void> implements LoginTaskObservable{
	
	private final static Logger log = Logger.getLogger(LoginTask.class);


	private OpenAAAService openAAAService;
	
	private List<LoginTaskListener> loginTaskListeners;
	
	private LoginInfomation loginInfomation;


	public LoginTask(OpenAAAService openAAAService, LoginInfomation loginInfomation ){
		
		this.openAAAService = openAAAService;
		this.loginInfomation = loginInfomation;
	}
	
	public LoginTask(){};

	@Override
	protected Void call() throws Exception {
		
		update("正在登录...");
		//获取IP地址
		String ip = null;
		
		try{
			
			ip = openAAAService.getIpAddress();
			log.debug("got IP address:"+ip);
			
		}catch(ConnectServerFailedException e){
			
			update("网络错误");
			
		}
		//为登录信息设置IP
		
		loginInfomation.setIpAddress(ip);

		//开始登录
		try{
			openAAAService.login(loginInfomation);

		}catch(ConnectServerFailedException e){
			
			update("网络错误");
			updateResult(LoginResultType.CANT_CONNECT_SERVER);
			return null;

		}catch(ErrorTokenStringException e){

			update("验证码错误");
			updateResult(LoginResultType.ERROR_TOKEN);
			return null;


		}catch(AuthenticationException e){

			update("用户或密码错误");
			updateResult(LoginResultType.USER_ERROR);
			return null;
		}catch (ErrorIPException e) {
			
			update("IP 地址错误");
			updateResult(LoginResultType.ERROR_IP);
			return null;
		}

		//登录成功
		update("登录成功");
		updateResult(LoginResultType.SUCCESS);
		return null;
		
	}

	@Override
	public void addLoginTaskListener(LoginTaskListener loginTaskListener) {
		
		if( loginTaskListeners == null ){
			loginTaskListeners = new ArrayList<>();
		}
		
		loginTaskListeners.add(loginTaskListener);
		
	}

	@Override
	public void removeLoginTaskListener(LoginTaskListener loginTaskListener) {
		
		if( loginTaskListeners == null ){
			loginTaskListeners = new ArrayList<>();
		}
		
		loginTaskListeners.remove(loginTaskListener);
		
	}

	@Override
	public void removeAll() {
		
		loginTaskListeners = null;
		
	}

	@Override
	public void update(String message) {
		
		if( loginTaskListeners != null ){
			for( LoginTaskListener loginTaskListener : loginTaskListeners ){
				
				loginTaskListener.handleMessage(message);
				
			}
		}
		
	}
	
	@Override
	public void updateResult(LoginResultType type) {
		
		if( loginTaskListeners != null ){
			
			for( LoginTaskListener loginTaskListener : loginTaskListeners ){
				
				loginTaskListener.receiveLoginResult(type);
				
			}
		}
		
	}

	
	

	public OpenAAAService getOpenAAAService() {
		return openAAAService;
	}

	public void setOpenAAAService(OpenAAAService openAAAService) {
		this.openAAAService = openAAAService;
	}

	public List<LoginTaskListener> getLoginTaskListeners() {
		return loginTaskListeners;
	}

	public void setLoginTaskListeners(List<LoginTaskListener> loginTaskListeners) {
		this.loginTaskListeners = loginTaskListeners;
	}

	public LoginInfomation getLoginInfomation() {
		return loginInfomation;
	}

	public void setLoginInfomation(LoginInfomation loginInfomation) {
		this.loginInfomation = loginInfomation;
	}


}

