package com.feng.foa.newtask.observable;

import com.feng.foa.newtask.listener.TimeCounterForGetCaptchaTaskListener;


/**
 * 获取验证图片倒计时任务的可观察性接口。此接口为<code>TimeCounterForGetCaptchaTask
 * </code>提供了相应方法使得<code>TimeCounterForGetCaptchaTask</code>成为一个可
 * 观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 * @see TimeCounterForGetCaptchaTaskListener
 *
 */
public interface TimeCounterForGetCaptchaTaskObservable {

	/**
	 * 添加<code>TimeCounterForGetCaptchaTaskListener</code>。此方法将指定监听器
	 * 注册到当前中。
	 * 
	 * @param timeCounterForGetCaptchaTaskListener 获取验证图片任务监听器。
	 * @see TimeCounterForGetCaptchaTaskListener
	 */
	void addTimeCounterForGetCaptchaTaskListener
		( TimeCounterForGetCaptchaTaskListener timeCounterForGetCaptchaTaskListener );

	/**
	 * 移除<code>TimeCounterForGetCaptchaTaskListener</code>。此方法将指定监听器
	 * 从当前对象中移除。
	 * 
	 * @param timeCounterForGetCaptchaTaskListener 获取验证图片任务监听器。
	 * @see TimeCounterForGetCaptchaTaskListener
	 */
	void removeTimeCounterForOnlineTaskListener
		( TimeCounterForGetCaptchaTaskListener timeCounterForGetCaptchaTaskListener );

	/**
	 * 移除当前对象中所有注册的监听器。
	 */
	void removeAll();
	/**
	 * 发送指定{@link String}类型的信息给监听器。
	 * 
	 * @param message {@link String}类型的信息。
	 */
	void update(String message);
	
	/**
	 * 将剩余时间发送给监听器。
	 * 
	 * @param time 时间(毫秒)。
	 */
	void updateHowLongToGetCapthcaTime(long time);

}
