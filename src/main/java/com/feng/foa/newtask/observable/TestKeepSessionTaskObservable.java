package com.feng.foa.newtask.observable;

import com.feng.foa.model.KeepSessionType;
import com.feng.foa.newtask.listener.TestKeepSessionTaskListener;


/**
 * 测试维护会话任务的可观察性接口。此接口为<code>TestKeepSessionTask</code>提供了相应方法使得
 * <code>TestKeepSessionTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 * @see TestKeepSessionTaskListener
 * @see KeepSessionType
 *
 */
public interface TestKeepSessionTaskObservable {

	/**
	 * 添加<code>TestKeepSessionTaskListener</code>。此方法将指定监听器注册到当前对象中。
	 * 
	 * @param testKeepSessionTaskListener  测试维护会话监听器。
	 * @see TestKeepSessionTaskListener
	 */
	void addTestKeepSessionTaskListener( TestKeepSessionTaskListener testKeepSessionTaskListener );

	/**
	 * 移除<code>TestKeepSessionTaskListener</code>。此方法将指定监听器从当前对象中移除。
	 * 
	 * @param testKeepSessionTaskListener 测试维护会话监听器。
	 * @see TestKeepSessionTaskListener
	 */
	void removeTestKeepSessionTaskListener(TestKeepSessionTaskListener testKeepSessionTaskListener);

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
	 * 将测试维护会话的结果发送给监听器。
	 * 
	 * @param type 测试维护会话的结果。
	 * @see KeepSessionType
	 */
	void updateResult(KeepSessionType type);

}
