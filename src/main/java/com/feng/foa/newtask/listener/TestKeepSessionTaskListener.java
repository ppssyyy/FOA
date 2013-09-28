package com.feng.foa.newtask.listener;

import com.feng.foa.model.KeepSessionType;


/**
 * 测试维护会话监听器。
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface TestKeepSessionTaskListener extends TaskListener{
	
	/**
	 * 收到测试维护会话执行结果后执行方法。
	 * @param type
	 */
	void testKeepSessionAction(KeepSessionType type);

}
