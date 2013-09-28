package com.feng.foa.newtask.observable;

import com.feng.foa.newtask.listener.LogoutTaskListener;


/**
 * 注销任务的可观察性接口。此接口为<code>LogoutTask</code>提供了相应方法使得
 * <code>LogoutTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 * @see LogoutTaskListener
 *
 */
public interface LogoutTaskObservable {
	
	/**
	 * 添加<code>LogoutTaskListener</code>。此方法将指定的监听器注册到当前对象中。
	 * 
	 * @param logoutTaskListener 注销任务监听器。
	 * @see LogoutTaskListener
	 */
	void addLogoutTaskListener(LogoutTaskListener logoutTaskListener);
	
	/**
	 * 添加<code>LogoutTaskListener</code>。此方法将指定的监听器注册到当前对象中移除。
	 * 
	 * @param logoutTaskListener 注销任务监听器。
	 * @see LogoutTaskListener
	 */
	void removeLogoutTaskListener(LogoutTaskListener logoutTaskListener);
	
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

}
