package com.feng.openaaa.newtask;


/**
 * 
 */
import java.util.ArrayList;
import java.util.List;
import com.feng.openaaa.exception.ConnectServerFailedException;
import com.feng.openaaa.newtask.listener.GetCaptchaTaskListener;
import com.feng.openaaa.newtask.observable.GetCaptchaTaskObservable;
import com.feng.openaaa.service.OpenAAAService;

import javafx.concurrent.Task;

public class GetCaptchaTask extends Task<byte[]> implements GetCaptchaTaskObservable{

	private OpenAAAService openAAAService;
	
	private List<GetCaptchaTaskListener> captchaTaskListeners;
	

	public GetCaptchaTask( OpenAAAService openAAAService ){

		this.openAAAService = openAAAService;
	}
	
	public GetCaptchaTask(){};

	@Override
	protected byte[] call() throws Exception {

		byte[] pictureBytes = null;

		try{
			update("正在获取验证图片");
			pictureBytes = openAAAService.getTokenPicture();
//			pictrueDisplayer.showPicture(pictureBytes);	
			update(pictureBytes);
			update("四句任选一句");
			
		}catch(Exception e){
			update("网络错误!");
			throw new ConnectServerFailedException("Can't connect server");
		}finally{
			//TODO
			
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
	public void addCaptchaTaskListener(
			GetCaptchaTaskListener captchaTaskListener) {
		if( captchaTaskListeners == null ){
			captchaTaskListeners = new ArrayList<>();
		}
		
		captchaTaskListeners.add(captchaTaskListener);
		
		
	}

	@Override
	public void removeCaptchaTaskListener(
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
