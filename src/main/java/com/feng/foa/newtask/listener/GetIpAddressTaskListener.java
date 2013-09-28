package com.feng.foa.newtask.listener;


/**
 * 获取IP地址任务监听器。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface GetIpAddressTaskListener {
	
	void handleMessage(String message);
	
	void getIpAddressSuccess(String ip);
	
	

}
