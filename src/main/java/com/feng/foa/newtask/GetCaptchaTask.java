package com.feng.foa.newtask;

import java.util.ArrayList;
import java.util.List;

import com.feng.foa.exception.ConnectServerFailedException;
import com.feng.foa.newtask.listener.GetCaptchaTaskListener;
import com.feng.foa.newtask.observable.GetCaptchaTaskObservable;
import com.feng.foa.service.OpenAAAService;

import javafx.concurrent.Task;

/**
 * 获取验证图片任务。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 * @see GetCaptchaTaskObservable
 */
public class GetCaptchaTask extends Task<byte[]> implements GetCaptchaTaskObservable{

	private OpenAAAService openAAAService;
	
	private List<GetCaptchaTaskListener> captchaTaskListeners;
	
	/**
	 * 通过<code>OpenAAAService</code>对象，构造当前对象。
	 * 
	 * @param openAAAService <code>OpenAAAService</code>对象。
	 */
	public GetCaptchaTask( OpenAAAService openAAAService ){

		this.openAAAService = openAAAService;
	}
	
	/**
	 * 无参构造方法。
	 */
	public GetCaptchaTask(){};

	@Override
	protected byte[] call() throws Exception {

		byte[] pictureBytes = null;

		try{
			update("正在获取验证图片");
			pictureBytes = openAAAService.getTokenPicture();
			update(pictureBytes);
			update("四句任选一句");
			
		}catch(Exception e){
			update("网络错误!");
			throw new ConnectServerFailedException("Can't connect server");
		}

		return pictureBytes;
	}


	public OpenAAAService getOpenAAAService() {
		return openAAAService;
	}

	public void setOpenAAAService(OpenAAAService openAAAService) {
		this.openAAAService = openAAAService;
	}
	
	
	@Override
	public void update(String message){
		if( captchaTaskListeners != null ){
			for(GetCaptchaTaskListener captchaTaskListener : captchaTaskListeners){
				
				captchaTaskListener.handleMessage(message);
			}
		}
	}
	
	@Override
	public void update(byte[] bytes){
		if( captchaTaskListeners != null ){
			for(GetCaptchaTaskListener captchaTaskListener : captchaTaskListeners){
				
				captchaTaskListener.GetCapchaSuccess(bytes);
			}
		}
	}

	@Override
	public void addGetCaptchaTaskListener(
			GetCaptchaTaskListener captchaTaskListener) {
		if( captchaTaskListeners == null ){
			captchaTaskListeners = new ArrayList<>();
		}
		
		captchaTaskListeners.add(captchaTaskListener);
		
		
	}

	@Override
	public void removeGetCaptchaTaskListener(
			GetCaptchaTaskListener captchaTaskListener) {
		
		if( captchaTaskListeners == null ){
			captchaTaskListeners = new ArrayList<>();
		}
		
		captchaTaskListeners.remove(captchaTaskListener);
		
	}

	@Override
	public void removeAll() {
		
		captchaTaskListeners = null;
		
	}
	
	
	

}
