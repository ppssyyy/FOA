package com.feng.openaaa.newtask;

import java.util.ArrayList;
import java.util.List;

import com.feng.openaaa.exception.ConnectServerFailedException;
import com.feng.openaaa.newtask.listener.GetIpAddressTaskListener;
import com.feng.openaaa.newtask.observable.GetIPAddressTaskObservable;
import com.feng.openaaa.service.OpenAAAService;

import javafx.concurrent.Task;

/**
 * 
 * @author fengyouchao
 *
 */
public class GetIpAddressTask extends Task<String> implements GetIPAddressTaskObservable{

	private OpenAAAService openAAAService;
	
	private List<GetIpAddressTaskListener> ipAddressTaskListeners;

	public GetIpAddressTask( OpenAAAService openAAAService ){
		this.openAAAService = openAAAService;
	}
	
	public GetIpAddressTask(){};
	

	@Override
	protected String call() throws Exception {
		String ip = null;
		try{
			
			ip = openAAAService.getIpAddress();
			updateSuccess(ip);
			
		}catch(ConnectServerFailedException e){
			update("连接服务器失败");
			throw new ConnectServerFailedException("Can't get ip address form server", e);
		}
		return ip;
	}

	public OpenAAAService getOpenAAAService() {
		return openAAAService;
	}

	public void setOpenAAAService(OpenAAAService openAAAService) {
		this.openAAAService = openAAAService;
	}

	@Override
	public void addGetIpAddressTaskListener(
			GetIpAddressTaskListener ipAddressTaskListener) {
		if( ipAddressTaskListeners == null ){
			ipAddressTaskListeners = new ArrayList<>();
		}
		
		ipAddressTaskListeners.add(ipAddressTaskListener);
		
	}

	@Override
	public void removeGetIpAddressTaskListener(
			GetIpAddressTaskListener ipAddressTaskListener) {
		
		if( ipAddressTaskListeners == null ){
			ipAddressTaskListeners = new ArrayList<>();
		}
		
		ipAddressTaskListeners.remove(ipAddressTaskListener);
		
	}

	@Override
	public void update(String message) {
		if( ipAddressTaskListeners != null ){
			for(GetIpAddressTaskListener ipAddressTaskListener : ipAddressTaskListeners){
				ipAddressTaskListener.handleMessage(message);
			}
		}
		
	}

	@Override
	public void removeAll() {
		
		ipAddressTaskListeners = null;
		
	}

	@Override
	public void updateSuccess(String ip) {
		
		if( ipAddressTaskListeners != null ){
			for(GetIpAddressTaskListener ipAddressTaskListener : ipAddressTaskListeners){
				ipAddressTaskListener.getIpAddressSuccess(ip);
			}
		}
		
	}

}
