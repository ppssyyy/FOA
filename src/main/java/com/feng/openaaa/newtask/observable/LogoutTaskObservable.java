package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.newtask.listener.LogoutTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface LogoutTaskObservable {
	
	void addLogoutTaskListener(LogoutTaskListener logoutTaskListener);
	
	void removeLogoutTaskListener(LogoutTaskListener logoutTaskListener);
	
	void removeAll();
	
	void update(String message);

}
