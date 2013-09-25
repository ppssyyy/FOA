package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.newtask.listener.GetIpAddressTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface GetIPAddressTaskObservable {
	
	void addGetIpAddressTaskListener(GetIpAddressTaskListener ipAddressTaskListener);
	
	void removeGetIpAddressTaskListener(GetIpAddressTaskListener ipAddressTaskListener);
	
	void removeAll();
	
	void update(String message);
	
	void updateSuccess(String ip);


}
