package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.model.LoginResultType;
import com.feng.openaaa.newtask.listener.LoginTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface LoginTaskObservable {
	
	void addLoginTaskListener(LoginTaskListener loginTaskListener);
	
	void removeLoginTaskListener(LoginTaskListener loginTaskListener);
	
	void removeAll();
	
	void update(String message);
	
	void updateResult(LoginResultType type);

}
