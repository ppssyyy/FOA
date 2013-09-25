package com.feng.openaaa.newtask;

import java.util.ArrayList;
import java.util.List;

import com.feng.openaaa.exception.ConnectServerFailedException;
import com.feng.openaaa.exception.ErrorTokenStringException;
import com.feng.openaaa.newtask.listener.LogoutTaskListener;
import com.feng.openaaa.newtask.observable.LogoutTaskObservable;
import com.feng.openaaa.service.OpenAAAService;

import javafx.concurrent.Task;


/**
 * 
 * @author fengyouchao
 *
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
