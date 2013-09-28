package com.feng.foa.newtask.listener;


/**
 * 获取验证图片任务监听器。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface GetCaptchaTaskListener  extends TaskListener{
	
	void GetCapchaSuccess(byte[] bytes);

}
