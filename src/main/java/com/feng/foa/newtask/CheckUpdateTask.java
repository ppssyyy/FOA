package com.feng.foa.newtask;

import java.util.ArrayList;
import java.util.List;

import javafx.concurrent.Task;

import com.feng.foa.exception.ConnectServerFailedException;
import com.feng.foa.newtask.listener.CheckUpdateTaskListener;
import com.feng.foa.newtask.observable.CheckUpdateTaskObservable;
import com.feng.foa.service.OpenAAAService;

/**
 * 检查更新任务,主要检查OpenAAA API的版本是否需要更新。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 * @see CheckUpdateTaskObservable
 *
 */
public class CheckUpdateTask extends Task<Void> implements CheckUpdateTaskObservable{

	private OpenAAAService openAAAService;
	
	//观察者集合，用户通知监听器。
	private List<CheckUpdateTaskListener> checkUpdateTaskListeners;

	/**
	 * 通过<code>OpenAAAService</code>对象构造<code>CheckUpdateTask</code>对象。
	 * 
	 * @param openAAAService <code>OpenAAAService</code>对象
	 */
	public CheckUpdateTask( OpenAAAService openAAAService ){
		this.openAAAService = openAAAService;
	}
	
	/**
	 * 无参构造方法。
	 */
	public CheckUpdateTask(){};

	@Override
	protected Void call() throws Exception {

		boolean needUpdate = false;
		boolean networkAvailable = false;
		

		try{
			needUpdate  = openAAAService.isAPINeedUpdate();
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
