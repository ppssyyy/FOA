package com.feng.foa.newtask.listener;


/**
 * 获取验证图片倒计时任务的监听器。
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface TimeCounterForGetCaptchaTaskListener extends TaskListener{
	
	void updateHowLongToGetCaptchaTime(long time);

}
