package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.newtask.listener.CheckUpdateTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface CheckUpdateTaskObservable {
	
	void addCheckUpdateTaskListener(CheckUpdateTaskListener checkUpdateTaskListener);
	
	void removeCheckUpdateTaskListener(CheckUpdateTaskListener checkUpdateTaskListener);
	
	void removeAll();
	
	void update(String message);

}
