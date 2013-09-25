package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.model.KeepSessionType;
import com.feng.openaaa.newtask.listener.KeepSessionTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface KeepSessionTaskObservable {

	void addKeepSessionTaskListener(KeepSessionTaskListener keepSessionTaskListener);

	void removeKeepSessionTaskListener(KeepSessionTaskListener keepSessionTaskListener);

	void removeAll();

	void update(String message);

	void updateEachAction(KeepSessionType type);
	
	void updateFinalAction();

}
