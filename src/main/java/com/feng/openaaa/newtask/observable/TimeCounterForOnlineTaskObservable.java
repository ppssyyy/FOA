package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.newtask.listener.TimeCounterForOnlineTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface TimeCounterForOnlineTaskObservable {

	void addTimeCounterForOnlineTaskListener( TimeCounterForOnlineTaskListener taskListener );

	void removeTimeCounterForOnlineTaskListener(TimeCounterForOnlineTaskListener taskListener);

	void removeAll();
	
	void update(String message);
	
	void updateOnelineTime(String time);

}
