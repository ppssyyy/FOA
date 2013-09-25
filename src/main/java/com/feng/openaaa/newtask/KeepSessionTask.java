package com.feng.openaaa.newtask;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.feng.openaaa.exception.AuthenticationException;
import com.feng.openaaa.exception.ConnectServerFailedException;
import com.feng.openaaa.exception.ErrorTokenStringException;
import com.feng.openaaa.exception.UnknownException;
import com.feng.openaaa.model.KeepSessionType;
import com.feng.openaaa.newtask.listener.KeepSessionTaskListener;
import com.feng.openaaa.newtask.observable.KeepSessionTaskObservable;
import com.feng.openaaa.service.OpenAAAService;

import javafx.concurrent.Task;


/**
 * 
 * @author fengyouchao
 *
 */
public class KeepSessionTask extends Task<String> implements KeepSessionTaskObservable{


	private final static Logger log = Logger.getLogger(KeepSessionTask.class);
	
	private OpenAAAService openAAAService;

	private List<KeepSessionTaskListener> keepSessionTaskListeners;

	private String tokenString;
	private String id;
	
	//维持session的时间间隔(毫秒)
	private long keepSessionTime = 7000;
	//结束总时间
	private long getPictureTime = 60000;

	public KeepSessionTask( OpenAAAService openAAAService ,String id, String tokenString ){

		this.openAAAService = openAAAService;
		this.tokenString = tokenString;
		this.id = id;
		
	}

	@Override
	protected String call() throws Exception {
		
		long totalTime = 0;
		int i = 0;

		while(true){
			
			
			
			try{
				
				openAAAService.keepSession(id, tokenString);

			}catch( ConnectServerFailedException e ){
				
				log.debug(e);
				update("网络错误");
				updateEachAction( KeepSessionType.CANT_CONNECT_SERVER );
				return null;
				
			}catch (ErrorTokenStringException e) {
				
				log.debug(e);
				updateEachAction( KeepSessionType.TOKEN_ERROR );
				update("验证码错误");
				return null;
				
			}catch (UnknownException e) {
				
				log.debug(e);
				update("未知错误");
				updateEachAction( KeepSessionType.UNKNOW_ERROR );
				return null;
				
			}catch (AuthenticationException e) {
				
				log.debug(e);
				update("无效会话");
				updateEachAction( KeepSessionType.NO_SESSION );
				return null;
				
			}
			
			i++;
			log.debug("KeepSession time:"+i);
			
			updateEachAction( KeepSessionType.SUCCESS );
			
			//计算维持session的总时间
			totalTime += keepSessionTime;
			//超出总时间跳出
			if(totalTime >= getPictureTime){
				break;
			}
			
			Thread.sleep(keepSessionTime);
			
			
		}
		
		updateFinalAction();
		
		return null;
	}


	@Override
	public void addKeepSessionTaskListener(
			KeepSessionTaskListener keepSessionTaskListener) {

		if( keepSessionTaskListeners == null ){
			keepSessionTaskListeners = new ArrayList<>();
		}

		keepSessionTaskListeners.add(keepSessionTaskListener);

	}

	@Override
	public void removeKeepSessionTaskListener(
			KeepSessionTaskListener keepSessionTaskListener) {

		if( keepSessionTaskListeners == null ){
			keepSessionTaskListeners = new ArrayList<>();
		}

		keepSessionTaskListeners.add(keepSessionTaskListener);

	}

	@Override
	public void removeAll() {

		keepSessionTaskListeners = null;

	}

	@Override
	public void update(String message) {

		if( keepSessionTaskListeners != null ){

			for( KeepSessionTaskListener keepSessionTaskListener : keepSessionTaskListeners ){

				keepSessionTaskListener.handleMessage(message);

			}

		}

	}

	@Override
	public void updateEachAction(KeepSessionType type) {
		
		if( keepSessionTaskListeners != null ){

			for( KeepSessionTaskListener keepSessionTaskListener : keepSessionTaskListeners ){

				keepSessionTaskListener.receiveKeepSessionResult(type);

			}

		}

	}

	@Override
	public void updateFinalAction() {
		if( keepSessionTaskListeners != null ){

			for( KeepSessionTaskListener keepSessionTaskListener : keepSessionTaskListeners ){

				keepSessionTaskListener.keepSessionFinished();

			}

		}

	}
	
	
	public OpenAAAService getOpenAAAService() {
		return openAAAService;
	}

	public void setOpenAAAService(OpenAAAService openAAAService) {
		this.openAAAService = openAAAService;
	}


	public String getTokenString() {
		return tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getKeepSessionTime() {
		return keepSessionTime;
	}

	public void setKeepSessionTime(long keepSessionTime) {
		this.keepSessionTime = keepSessionTime;
	}

	public long getGetPictureTime() {
		return getPictureTime;
	}

	public void setGetPictureTime(long getPictureTime) {
		this.getPictureTime = getPictureTime;
	}



}
