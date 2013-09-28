package com.feng.foa.controller;


/**
 * 以线程方式显示信息。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public class ShowMessageThread implements Runnable{

	private String message;
	private MessageInformer messageInformer;

	/**
	 * 在指定信息通知器中显示指定的信息。
	 * 
	 * @param message	要显示的信息内容。
	 * @param messageInformer 信息通知器对象。
	 */
	public ShowMessageThread( String message, MessageInformer messageInformer ){ 
		this.message = message;
		this.messageInformer = messageInformer;
	}

	@Override
	public void run() {
		
		messageInformer.showMessage(message);

	}

}
