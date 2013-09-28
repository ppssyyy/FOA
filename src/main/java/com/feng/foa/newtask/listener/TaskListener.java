package com.feng.foa.newtask.listener;


/**
 * 任务监听器。定义通用的监听方法。
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface TaskListener {
	
	/**
	 * 处理信息方法。
	 * 
	 * @param message 任务对象发送的信息。
	 */
	void handleMessage(String message);

}
