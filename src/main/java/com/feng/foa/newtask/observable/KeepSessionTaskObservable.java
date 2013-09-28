package com.feng.foa.newtask.observable;

import com.feng.foa.model.KeepSessionType;
import com.feng.foa.newtask.listener.KeepSessionTaskListener;


/**
 * 维护会话任务的可观察性接口。此接口为<code>KeepSessionTask</code>提供了相应方法使得
 * <code>KeepSessionTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 * @see KeepSessionTaskListener
 * @see KeepSessionType
 *
 */
public interface KeepSessionTaskObservable {

	/**
	 * 添加<code>KeepSessionTaskListener</code>。此方法将指定的监听器注册到当前
	 * <code>KeepSessionTaskObservable</code>对象中。使得监听器可以监听当前<code>
	 * KeepSessionTaskObservable</code>对象的相关信息。
	 * 
	 * @param keepSessionTaskListener 维护会话任务监听器。
	 */
	void addKeepSessionTaskListener(KeepSessionTaskListener keepSessionTaskListener);

	/**
	 * 移除<code>KeepSessionTaskListener</code>。此方法将指定的监听器从当前<code>
	 * KeepSessionTaskObservable</code>对象中移除，使得该监听器不再监听当前对象。
	 * 
	 * @param keepSessionTaskListener
	 */
	void removeKeepSessionTaskListener(KeepSessionTaskListener keepSessionTaskListener);

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
	 * 把每一次的执行结果通知给监听器。
	 * 
	 * @param type {@link KeepSessionType}对象。维护会话的结果。
	 * @see KeepSessionType
	 */
	void updateEachAction(KeepSessionType type);
	
	/**
	 * 任务结束时通知监听器。
	 */
	void updateFinalAction();

}
