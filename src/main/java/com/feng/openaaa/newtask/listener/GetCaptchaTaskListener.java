package com.feng.openaaa.newtask.listener;


/**
 * 
 * @author fengyouchao
 *
 */
public interface GetCaptchaTaskListener  extends TaskListener{
	
	void GetCapchaSuccess(byte[] bytes);

}
