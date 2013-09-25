package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.model.KeepSessionType;
import com.feng.openaaa.newtask.listener.TestKeepSessionTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface TestKeepSessionTaskObservable {

	void addTestKeepSessionTaskListener( TestKeepSessionTaskListener testKeepSessionTaskListener );

	void removeTestKeepSessionTaskListener(TestKeepSessionTaskListener testKeepSessionTaskListener);

	void removeAll();
	
	void update(String message);
	
	void updateAction(KeepSessionType type);

}
