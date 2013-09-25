package com.feng.openaaa.newtask.listener;

import com.feng.openaaa.model.KeepSessionType;


/**
 * 
 * @author fengyouchao
 *
 */
public interface TestKeepSessionTaskListener extends TaskListener{
	
	void testKeepSessionAction(KeepSessionType type);

}
