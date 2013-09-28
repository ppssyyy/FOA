package com.feng.foa.newtask.observable;

import com.feng.foa.model.LoginResultType;
import com.feng.foa.newtask.listener.LoginTaskListener;


/**
 * 登录任务的可观察性接口。此接口为<code>LoginTask</code>提供了相应方法使得
 * <code>LoginTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 * @see LoginTaskListener
 * @see LoginResultType
 *
 */
public interface LoginTaskObservable {
	
	/**
	 * 添加<code>LoginTaskListener</code>。此方法将指定的监听器注册到当前对象中。
	 * 
	 * @param loginTaskListener 登录任务监听器。 
	 * @see LoginTaskListener
	 */
	void addLoginTaskListener(LoginTaskListener loginTaskListener);
	
	/**
	 * 移除<code>LoginTaskListener<c/ode>。此方法将指定的监听器从当对象中移除。
	 * 
	 * @param loginTaskListener 登录任务监听器。
	 * @see LoginTaskListener
	 */
	void removeLoginTaskListener(LoginTaskListener loginTaskListener);
	
	
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
	 * 将登陆结构发送给监听器。
	 * 
	 * @param type 登录结果。
	 * @see LoginResultType
	 */
	void updateResult(LoginResultType type);

}
