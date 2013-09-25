package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.newtask.listener.TimeCounterForGetCaptchaTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface TimeCounterForGetCaptchaTaskObservable {

	void addTimeCounterForGetCaptchaTaskListener
		( TimeCounterForGetCaptchaTaskListener timeCounterForGetCaptchaTaskListener );

	void removeTimeCounterForOnlineTaskListener
		( TimeCounterForGetCaptchaTaskListener timeCounterForGetCaptchaTaskListener );

	void removeAll();
	
	void update(String message);
	
	void updateHowLongToGetCapthcaTime(long time);

}
