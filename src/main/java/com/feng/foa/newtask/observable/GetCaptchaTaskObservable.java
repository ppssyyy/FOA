package com.feng.foa.newtask.observable;

import com.feng.foa.newtask.listener.GetCaptchaTaskListener;


/**
 * 获取验证图片任务的可观察性接口。此接口为<code>GetCaptchaTask</code>提供了相应方法使得
 * <code>GetCaptchaTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 * @see GetCaptchaTaskListener
 *
 */
public interface GetCaptchaTaskObservable {
	
	/**
	 * 添加<code>GetCaptchaTaskListener</code>。注册监听器，此监听器将监听
	 * 当前<code>GetCaptchaTaskObservable</code>对象。
	 * 
	 * @param captchaTaskListener <code>GetCaptchaTaskListener</code>对象。
	 * @see GetCaptchaTaskListener
	 */
	void addGetCaptchaTaskListener(GetCaptchaTaskListener captchaTaskListener);
	
	/**
	 * 移除<code>GetCaptchaTaskListener</code>。移除指定的监听器，此监听器将
	 * 不会监听当前<code>GetCaptchaTaskObservable</code>对象。
	 * 
	 * @param captchaTaskListener <code>GetCaptchaTaskListener</code>对象。
	 * @see GetCaptchaTaskListener
	 */
	void removeGetCaptchaTaskListener(GetCaptchaTaskListener captchaTaskListener);
	
	/**
	 * 清空所有<code>GetCaptchaTaskListener</code>。调用方法后，该<code>GetCaptchaTaskObservable
	 * </code>将不会被任何监听器监听。
	 */
	void removeAll();
	
	/**
	 * 发送指定{@link String}类型的信息给监听器。
	 * 
	 * @param message {@link String}类型的信息。
	 */
	void update(String message);
	
	/**
	 * 发送验证图片byte数组给监听器。
	 * 
	 * @param bytes 验证图片byte的数组。
	 */
	void update(byte[] bytes);

}
