package com.feng.foa.newtask;

import java.util.ArrayList;
import java.util.List;

import com.feng.foa.exception.ConnectServerFailedException;
import com.feng.foa.exception.ErrorTokenStringException;
import com.feng.foa.newtask.listener.LogoutTaskListener;
import com.feng.foa.newtask.observable.LogoutTaskObservable;
import com.feng.foa.service.OpenAAAService;

import javafx.concurrent.Task;


/**
 * 注销任务。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 * @see LogoutTaskObservable
 */
public class LogoutTask extends Task<Void> implements LogoutTaskObservable{
	
	private OpenAAAService openAAAService;
	private List<LogoutTaskListener> logoutTaskListeners;
	
	private String id;
	private String token;
	
	public LogoutTask(){};
	
	public LogoutTask(OpenAAAService openAAAService, String id, String token){
		
		this.openAAAService = openAAAService;
		this.id = id;
		this.token = token;
	}

	@Override
	protected Void call() throws Exception {
		try{
			openAAAService.logout(id, token);
		}catch(ConnectServerFailedException e){
			update("网络错误");
			return null;
			
		}catch (ErrorTokenStringException e) {
			update("验证码错误");
			return null;
		}
		return null;
	}

	@Override
	public void addLogoutTaskListener(LogoutTaskListener logoutTaskListener) {
		
		if( logoutTaskListeners == null ){
			logoutTaskListeners = new ArrayList<>();
		}
		
		logoutTaskListeners.add(logoutTaskListener);
		
	}

	@Override
	public void removeLogoutTaskListener(LogoutTaskListener logoutTaskListener) {
		
		if( logoutTaskListeners == null ){
			logoutTaskListeners = new ArrayList<>();
		}
		
		logoutTaskListeners.remove(logoutTaskListener);
		
	}

	@Override
	public void removeAll() {
		
		logoutTaskListeners = null;
		
	}

	@Override
	public void update(String message) {
		
		if( logoutTaskListeners != null ){
			
			for( LogoutTaskListener logoutTaskListener : logoutTaskListeners ){
				
				logoutTaskListener.handleMessage(message);
				
			}
			
		}
		
	}

}
