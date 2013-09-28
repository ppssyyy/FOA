package com.feng.foa.newtask.observable;

import com.feng.foa.newtask.listener.CheckUpdateTaskListener;


/**
 * 检查更新任务的可观察性接口。此接口为<code>CheckUpdateTask</code>提供了相应方法使得
 * <code>CheckUpdateTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface CheckUpdateTaskObservable {
	
	/**
	 * 添加<code>CheckUpdateTaskListener</code>对象。
	 * @param checkUpdateTaskListener <code>CheckUpdateTaskListener</code>对象。
	 * 此对象将会监听当前<code>CheckUpdateTaskObservable</code>对象发送的消息。
	 * 
	 * @see CheckUpdateTaskListener
	 */
	void addCheckUpdateTaskListener(CheckUpdateTaskListener checkUpdateTaskListener);
	
	/**
	 * 移除<code>CheckUpdateTaskListener</code>对象。
	 * @param checkUpdateTaskListener <code>CheckUpdateTaskListener</code>对象。
	 * 此对象将不会监听当前<code>CheckUpdateTaskObservable</code>对象发送的消息。
	 * 
	 * @see CheckUpdateTaskListener
	 */
	void removeCheckUpdateTaskListener(CheckUpdateTaskListener checkUpdateTaskListener);
	
	/**
	 * 清空监听器。当前<code>CheckUpdateTaskObservable</code>对象将不会被任何
	 * <code>CheckUpdateTaskListener</code>对象监听。
	 */
	void removeAll();
	
	/**
	 * 更新，发送一个{@link String}类型的信息给监听器。
	 * @param message {@link String}类型的信息。
	 */
	void update(String message);

}
