package com.feng.openaaa.newtask;

import java.util.ArrayList;
import java.util.List;

import com.feng.openaaa.newtask.listener.TimeCounterForGetCaptchaTaskListener;
import com.feng.openaaa.newtask.observable.TimeCounterForGetCaptchaTaskObservable;

import javafx.concurrent.Task;


/**
 * 
 * @author fengyouchao
 *
 */
public class TimeCounterForGetCaptchaTask extends Task<Void> implements TimeCounterForGetCaptchaTaskObservable{

	private List<TimeCounterForGetCaptchaTaskListener> listeners;
	
	private long timeToGetCaptcha;
	
	public TimeCounterForGetCaptchaTask(){};
	
	public TimeCounterForGetCaptchaTask(long timeToGetCaptcha){
		
		this.timeToGetCaptcha = timeToGetCaptcha;
		
	}

	@Override
	protected Void call() throws Exception {
		
		while(timeToGetCaptcha>0){
			
			Thread.sleep(500);
			timeToGetCaptcha -= 500;
			updateHowLongToGetCapthcaTime(timeToGetCaptcha);
		}
		
		return null;
	}

	@Override
	public void addTimeCounterForGetCaptchaTaskListener(
			TimeCounterForGetCaptchaTaskListener listener) {

		if( listeners == null ){

			listeners = new ArrayList<>();
		}

		listeners.add(listener);

	}

	@Override
	public void removeTimeCounterForOnlineTaskListener(
			TimeCounterForGetCaptchaTaskListener listener) {

		if( listeners == null ){

			listeners = new ArrayList<>();
		}

		listeners.remove(listener);

	}

	@Override
	public void removeAll() {

		listeners = null;

	}

	@Override
	public void update(String message) {

		if( listeners != null ){

			for( TimeCounterForGetCaptchaTaskListener listener : listeners ){

				listener.handleMessage(message);

			}

		}

	}

	@Override
	public void updateHowLongToGetCapthcaTime(long time) {
		
		if( listeners != null ){

			for( TimeCounterForGetCaptchaTaskListener listener : listeners ){

				listener.updateHowLongToGetCaptchaTime(time);

			}

		}
		
	}

}
