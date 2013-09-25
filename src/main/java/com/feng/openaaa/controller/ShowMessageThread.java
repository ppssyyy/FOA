package com.feng.openaaa.controller;


/**
 * 
 * @author fengyouchao
 *
 */
public class ShowMessageThread implements Runnable{

	private String message;
	private MessageInformer messageInformer;

	public ShowMessageThread( String message, MessageInformer messageInformer ){ 
		this.message = message;
		this.messageInformer = messageInformer;
	}

	@Override
	public void run() {
		
		messageInformer.showMessage(message);

	}

}
