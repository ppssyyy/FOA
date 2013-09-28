package com.feng.foa.newtask.listener;

import com.feng.foa.model.LoginResultType;


/**
 * 登录任务监听器。
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface LoginTaskListener extends TaskListener{
	
	/**
	 * 收到登录结果后执行方法。
	 * @param type 登录的结果<code>LoginResultType</code>对象。
	 */
	void receiveLoginResult(LoginResultType type);

}
