package com.feng.foa.newtask.observable;

import com.feng.foa.newtask.listener.TimeCounterForOnlineTaskListener;


/**
 * 在线时间计时任务的可观察性接口。此接口为<code>TimeCounterForOnlineTask</code>
 * 提供了相应方法使得<code>TimeCounterForOnlineTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 * @see TimeCounterForOnlineTaskListener
 *
 */
public interface TimeCounterForOnlineTaskObservable {

	/**
	 * 添加<code>TimeCounterForOnlineTaskListener</code>。此方法将指定监听器
	 * 注册到当前对象中。
	 * 
	 * @param taskListener 在线时间计时任务监听器。
	 * @see TimeCounterForOnlineTaskListener
	 */
	void addTimeCounterForOnlineTaskListener( TimeCounterForOnlineTaskListener taskListener );

	/**
	 * 移除<code>TimeCounterForOnlineTaskListener</code>。此方法将指定监听器
	 * 从当前对象中移除。
	 * 
	 * @param taskListener 在线时间计时任务监听器。
	 * @see TimeCounterForOnlineTaskListener
	 */
	void removeTimeCounterForOnlineTaskListener(TimeCounterForOnlineTaskListener taskListener);

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
	 * 将在线时间发送给监听器。
	 * 
	 * @param time 时间(毫秒)。
	 */
	void updateOnlineTime(String time);

}
