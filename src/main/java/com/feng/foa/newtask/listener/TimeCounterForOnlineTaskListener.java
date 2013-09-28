package com.feng.foa.newtask.listener;


/**
 * 在线时间计时任务监听器。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface TimeCounterForOnlineTaskListener extends TaskListener{
	
	void updateOnlineTime(String time);

}
