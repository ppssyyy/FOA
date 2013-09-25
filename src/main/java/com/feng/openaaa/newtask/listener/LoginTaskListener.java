package com.feng.openaaa.newtask.listener;

import com.feng.openaaa.model.LoginResultType;


/**
 * 
 * @author fengyouchao
 *
 */
public interface LoginTaskListener extends TaskListener{
	
	void receiveLoginResult(LoginResultType type);

}
