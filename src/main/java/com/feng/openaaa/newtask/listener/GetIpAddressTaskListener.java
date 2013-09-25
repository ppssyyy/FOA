package com.feng.openaaa.newtask.listener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface GetIpAddressTaskListener {
	
	void handleMessage(String message);
	
	void getIpAddressSuccess(String ip);
	
	

}
