package com.feng.openaaa.newtask.observable;

import com.feng.openaaa.newtask.listener.GetCaptchaTaskListener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface GetCaptchaTaskObservable {
	
	void addCaptchaTaskListener(GetCaptchaTaskListener captchaTaskListener);
	
	void removeCaptchaTaskListener(GetCaptchaTaskListener captchaTaskListener);
	
	void removeAll();
	
	void update(String message);
	
	void update(byte[] bytes);

}
