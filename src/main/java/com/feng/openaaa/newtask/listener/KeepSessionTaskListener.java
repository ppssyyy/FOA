package com.feng.openaaa.newtask.listener;

import com.feng.openaaa.model.KeepSessionType;

/**
 * 
 * @author fengyouchao
 *
 */
public interface KeepSessionTaskListener extends TaskListener{
	
	void receiveKeepSessionResult(KeepSessionType type);
	
	void keepSessionFinished();

}
