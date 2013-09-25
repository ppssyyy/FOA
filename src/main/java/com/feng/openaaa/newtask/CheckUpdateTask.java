package com.feng.openaaa.newtask;

import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;

import com.feng.openaaa.exception.ConnectServerFailedException;
import com.feng.openaaa.newtask.listener.CheckUpdateTaskListener;
import com.feng.openaaa.newtask.observable.CheckUpdateTaskObservable;
import com.feng.openaaa.service.OpenAAAService;

/**
 * 
 * @author fengyouchao
 *
 */
public class CheckUpdateTask extends Task<Void> implements CheckUpdateTaskObservable{

	private OpenAAAService openAAAService;
	
	private List<CheckUpdateTaskListener> checkUpdateTaskListeners;

	public CheckUpdateTask( OpenAAAService openAAAService ){
		this.openAAAService = openAAAService;
	}
	
	public CheckUpdateTask(){};

	@Override
	protected Void call() throws Exception {

		boolean needUpdate = false;
		boolean networkAvailable = false;
		

		try{
			needUpdate  = openAAAService.isNeedUpdate();
			networkAvailable = true;
		}catch(ConnectServerFailedException e){
			
			throw new ConnectServerFailedException("Can't connect server", e);
			
		}finally{
			
			if(needUpdate){
				update("客户端需要更新");
				
			}
			if(!networkAvailable){
				update("请检查您的网络连接");
			}
			else{
				
			}
			
		}
		
		return null;


	}
	
	@Override
	public void update(String message){
		if(checkUpdateTaskListeners != null){
			for(CheckUpdateTaskListener listener: checkUpdateTaskListeners){
				listener.handleMessage(message);
			}
		}
	}

	@Override
	public void addCheckUpdateTaskListener(
			CheckUpdateTaskListener checkUpdateTaskListener) {
		if(checkUpdateTaskListeners == null){
			checkUpdateTaskListeners = new ArrayList<>();
		}
		
		checkUpdateTaskListeners.add(checkUpdateTaskListener);
		
	}

	@Override
	public void removeCheckUpdateTaskListener(
			CheckUpdateTaskListener checkUpdateTaskListener) {
		if(checkUpdateTaskListeners == null){
			return;
		}
		
		checkUpdateTaskListeners.remove(checkUpdateTaskListener);
		
	}

	@Override
	public void removeAll() {
		checkUpdateTaskListeners = null;
		
	}
}
