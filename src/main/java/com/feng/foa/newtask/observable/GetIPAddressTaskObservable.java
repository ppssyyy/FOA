package com.feng.foa.newtask.observable;

import com.feng.foa.newtask.listener.GetIpAddressTaskListener;


/**
 * 获取IP地址任务的可观察性接口。此接口为<code>GetIpAddressTask</code>提供了相应方法使得
 * <code>GetIpAddressTask</code>成为一个可观察的对象。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface GetIPAddressTaskObservable {
	
	/**
	 * 添加<code>GetIpAddressTaskListener</code>。注册监听器
	 * 被注册的监听器将会监听当前<code>GetIPAddressTaskObservable</code>对象。
	 * 
	 * @param getIPAddressTaskListener <code>GetIpAddressTaskListener</code>对象。
	 * 
	 * @see GetIpAddressTaskListener
	 */
	void addGetIPAddressTaskListener(GetIpAddressTaskListener getIPAddressTaskListener);
	
	
	/**
	 * 移除<code>GetIpAddressTaskListener</code>。此方法指定移除<code>GetIpAddressTaskListener
	 * </code>对象，使得指定<code>GetIpAddressTaskListener</code>对象不再监听当前<code>
	 * GetIPAddressTaskObservable</code>对象。
	 * 
	 * @param getIPAddressTaskListener <code>GetIpAddressTaskListener</code>对象。
	 * @see GetIpAddressTaskListener
	 */
	void removeGetIPAddressTaskListener(GetIpAddressTaskListener getIPAddressTaskListener);
	
	
	/**
	 * 清空所有<code>GetIpAddressTaskListener</code>。使用此方法将移除之前所添加所有<code>
	 * GetIpAddressTaskListener</code>。
	 */
	void removeAll();
	
	/**
	 * 发送指定{@link String}类型的信息给监听器。
	 * 
	 * @param message {@link String}类型的信息。
	 */
	void update(String message);
	
	
	/**
	 * 当执行成功时，将{@link String}类型的IP发送给监听器。
	 * 
	 * @param IP {@link String}类型的IP地址。
	 */
	void updateSuccess(String IP);


}
