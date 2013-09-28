package com.feng.foa.newtask.listener;

import com.feng.foa.model.KeepSessionType;

/**
 * 保持会话任务监听器。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface KeepSessionTaskListener extends TaskListener{
	
	/**
	 * 收到KeepSession任务的执行结果后执行的方法。
	 * 
	 * @param type <code>KeepSessionType</code>对象。
	 */
	void receiveKeepSessionResult(KeepSessionType type);
	
	/**
	 * 维护会话结束执行方法。
	 */
	void keepSessionFinished();

}
