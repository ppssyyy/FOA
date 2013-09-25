package com.feng.openaaa.newtask.listener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface TimeCounterForGetCaptchaTaskListener extends TaskListener{
	
	void updateHowLongToGetCaptchaTime(long time);

}
