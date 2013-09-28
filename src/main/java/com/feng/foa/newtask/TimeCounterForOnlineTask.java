package com.feng.foa.newtask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.feng.foa.newtask.listener.TimeCounterForOnlineTaskListener;
import com.feng.foa.newtask.observable.TimeCounterForOnlineTaskObservable;

import javafx.concurrent.Task;


/**
 * 在线时间计时任务。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 * @see TimeCounterForOnlineTaskObservable
 *
 */
public class TimeCounterForOnlineTask extends Task<Void> implements TimeCounterForOnlineTaskObservable{

	private List<TimeCounterForOnlineTaskListener> taskListeners;

	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	private boolean stop = false;

	@Override
	protected Void call() throws Exception {
		
		Calendar calendar = new GregorianCalendar();
		
		while(true){
			Thread.sleep(1000);
			second++;
			if(second==60){

				second = 0;
				minute++;

				if( minute == 60 ){

					minute = 0;
					hour++;
				}
			}
			
			calendar.set(Calendar.SECOND, second);
			calendar.set(Calendar.MINUTE, minute);
			calendar.set(Calendar.HOUR, hour);

			DateFormat dateFormat = new SimpleDateFormat(":mm:ss");
			String time1 = dateFormat.format(calendar.getTime());
			String hourString = ""+hour;
			if(hour < 10 ){
				hourString = "0"+hourString;
			}
			updateOnlineTime(hourString+time1);
			
			if(stop){
				break;
			}

		}
		return null;
	}

	@Override
	public void addTimeCounterForOnlineTaskListener(TimeCounterForOnlineTaskListener taskListener) {

		if( taskListeners == null ){

			taskListeners = new ArrayList<>();
		}

		taskListeners.add(taskListener);

	}

	@Override
	public void removeTimeCounterForOnlineTaskListener(
			TimeCounterForOnlineTaskListener taskListener) {

		if( taskListeners == null ){

			taskListeners = new ArrayList<>();
		}

		taskListeners.remove(taskListener);

	}

	@Override
	public void removeAll() {

		taskListeners = null;

	}

	@Override
	public void update(String message) {

		if( taskListeners != null ){

			for(TimeCounterForOnlineTaskListener taskListener : taskListeners ){

				taskListener.handleMessage(message);
			}

		}

	}

	@Override
	public void updateOnlineTime(String time) {

		if( taskListeners != null ){

			for(TimeCounterForOnlineTaskListener taskListener : taskListeners ){

				taskListener.updateOnlineTime(time);
			}

		}

	}
	
	public void stop(){
		stop = true;
	}

}
