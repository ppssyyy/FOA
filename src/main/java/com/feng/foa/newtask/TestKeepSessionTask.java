package com.feng.foa.newtask;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.feng.foa.exception.AuthenticationException;
import com.feng.foa.exception.ConnectServerFailedException;
import com.feng.foa.exception.ErrorTokenStringException;
import com.feng.foa.exception.UnknownException;
import com.feng.foa.model.KeepSessionType;
import com.feng.foa.newtask.listener.TestKeepSessionTaskListener;
import com.feng.foa.newtask.observable.TestKeepSessionTaskObservable;
import com.feng.foa.service.OpenAAAService;

import javafx.concurrent.Task;


/**
 * 测试维护会话。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 * @see TestKeepSessionTaskObservable
 *
 */
public class TestKeepSessionTask extends Task<String> implements TestKeepSessionTaskObservable{


	private final static Logger log = Logger.getLogger(TestKeepSessionTask.class);

	private OpenAAAService openAAAService;

	private List<TestKeepSessionTaskListener> testKeepSessionTaskListeners;

	private String tokenString;
	private String id;

	public TestKeepSessionTask( OpenAAAService openAAAService ,String id, String tokenString ){

		this.openAAAService = openAAAService;
		this.tokenString = tokenString;
		this.id = id;

	}

	@Override
	protected String call() throws Exception {

		try{

			openAAAService.keepSession(id, tokenString);

		}catch( ConnectServerFailedException e ){

			log.debug(e);
			update("网络错误");
			updateResult( KeepSessionType.CANT_CONNECT_SERVER );
			return null;

		}catch (ErrorTokenStringException e) {

			log.debug(e);
			updateResult( KeepSessionType.TOKEN_ERROR );
			update("验证码错误");
			return null;

		}catch (UnknownException e) {

			log.debug(e);
			update("未知错误");
			updateResult( KeepSessionType.UNKNOW_ERROR );
			return null;

		}catch (AuthenticationException e) {

			log.debug(e);
			update("无效会话");
			updateResult( KeepSessionType.NO_SESSION );
			return null;

		}

		updateResult(KeepSessionType.SUCCESS);

		return null;
	}


	@Override
	public void removeAll() {

		testKeepSessionTaskListeners = null;

	}

	@Override
	public void update(String message) {

		if( testKeepSessionTaskListeners != null ){

			for( TestKeepSessionTaskListener taskListener : testKeepSessionTaskListeners ){

				taskListener.handleMessage(message);

			}

		}

	}



	
	@Override
	public void addTestKeepSessionTaskListener(
			TestKeepSessionTaskListener testKeepSessionTaskListener) {
		
		if( testKeepSessionTaskListeners == null ){
			testKeepSessionTaskListeners = new ArrayList<>();
		}
		
		testKeepSessionTaskListeners.add(testKeepSessionTaskListener);
		
	}

	@Override
	public void removeTestKeepSessionTaskListener(
			TestKeepSessionTaskListener testKeepSessionTaskListener) {
		
		if( testKeepSessionTaskListeners == null ){
			testKeepSessionTaskListeners = new ArrayList<>();
		}
		
		testKeepSessionTaskListeners.remove(testKeepSessionTaskListener);
		
	}

	@Override
	public void updateResult(KeepSessionType type) {
		
		if( testKeepSessionTaskListeners != null ){

			for( TestKeepSessionTaskListener taskListener : testKeepSessionTaskListeners ){

				taskListener.testKeepSessionAction(type);

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


	

}
