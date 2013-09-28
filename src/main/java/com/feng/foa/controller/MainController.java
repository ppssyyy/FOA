package com.feng.foa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import com.feng.foa.exception.AuthenticationException;
import com.feng.foa.model.BasicInfomation;
import com.feng.foa.model.Constants;
import com.feng.foa.model.KeepSessionType;
import com.feng.foa.model.LoginInfomation;
import com.feng.foa.newtask.KeepSessionTask;
import com.feng.foa.newtask.LogoutTask;
import com.feng.foa.newtask.TimeCounterForGetCaptchaTask;
import com.feng.foa.newtask.TimeCounterForOnlineTask;
import com.feng.foa.newtask.listener.KeepSessionTaskListener;
import com.feng.foa.newtask.listener.LogoutTaskListener;
import com.feng.foa.newtask.listener.TimeCounterForGetCaptchaTaskListener;
import com.feng.foa.newtask.listener.TimeCounterForOnlineTaskListener;
import com.feng.foa.service.OpenAAAService;
import com.feng.foa.util.TimeFormater;


/**
 * 主界面的控制器。
 * 
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 *
 */
public class MainController implements Initializable,MessageInformer,
KeepSessionTaskListener, LogoutTaskListener, TimeCounterForOnlineTaskListener, 
TimeCounterForGetCaptchaTaskListener{

	private final static Logger log = Logger.getLogger(MainController.class);


	@FXML
	private Label messageLabel;				//显示提示信息label对象。

	@FXML
	private TextArea informationArea;		//显示用户信息的文本域。

	@FXML
	private Label onlineTimeLabel;			//显示在线时间的label对象。

	@FXML
	private Label timeToGetCaptchaLabeltimeToGetCaptchaLabel;	//显示获取验证图片的剩余时间的label对象。

	private String onlineTime = "00:00:00";		//在线时间的的String对象。
	
	private long getCaptchaTime = 0;			//获取验证码图片剩余时间(毫秒)。
	
	private KeepSessionTask keepSessionTask;	//维护会话的任务。
	
	private LogoutTask logoutTask;				//注销任务。
	
	private TimeCounterForOnlineTask timeCounterForOnlineTask;	//计算在线时间的任务。
	
	private TimeCounterForGetCaptchaTask timeCounterForGetCaptchaTask;	//计算获取验证图片剩余时间的任务。
	

	private OpenAAAService openAAAService;		//OpenAAAService对象,KeepSessionTask需要的对象。
	
	private ApplicationViewManager applicationViewManager;	//ApplicationViewManager对象，帮助页面跳转。
	
	private LoginInfomation loginInfomation;	//登陆信息对象。


	@FXML
	public void logoutAction(ActionEvent event){
		//终止keepSession线程
		if(keepSessionTask!=null&&keepSessionTask.isRunning()){
			keepSessionTask.cancel();
		}
		//终止获取验证图片倒计时线程
		if( timeCounterForGetCaptchaTask != null && timeCounterForGetCaptchaTask.isRunning() ){
			timeCounterForGetCaptchaTask.cancel();
		}

		//启动注销线程
		logoutTask = new LogoutTask(openAAAService, loginInfomation.getUserId(),
				loginInfomation.getTokenString());

		Thread t = new Thread(logoutTask);
		t.setDaemon(true);
		t.start();

		//清空用户数据
		ApplicationContext.remove(Constants.LOGIN_INFO);
		ApplicationContext.remove(Constants.USER_ID);
		ApplicationContext.remove(Constants.USER_PASSWORD);

		//跳转登陆界面
		applicationViewManager.goToLoginView();

	}

	@FXML
	public void getCaptchaAction(ActionEvent event){

		/*
		 * 终止keepSession线程,如果不终止，获取验证码图片，此线程可能会在用户输入验证码之前再次提交维护会话的任务，
		 * 并受到来自服务器的验证码错误的信息。
		 */
		if(keepSessionTask!=null&&keepSessionTask.isRunning()){
			keepSessionTask.cancel();
		}
		
		applicationViewManager.showInputTokenView();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//存储当前控制器
		ApplicationContext.set(Constants.MAIN_CONTROLLER, this);

		//获取OpenAAAService
		openAAAService = (OpenAAAService) ApplicationContext.get(Constants.OPEN_AAA_SERVICE);

		//获取ApplicationViewManager
		applicationViewManager = (ApplicationViewManager) 
				ApplicationContext.get(Constants.APP_VIEW_CONTROLER);

		//获取LoginInfomation
		loginInfomation = (LoginInfomation) ApplicationContext.get(Constants.LOGIN_INFO);

		//获取基本信息。
		BasicInfomation basicInfomation = null;
		try {
			basicInfomation = openAAAService.getBasicInformation();
		} catch (AuthenticationException e) {

			e.printStackTrace();
			log.error(e);
		}

		//如果用户的网络有效期未过，并且帐户时可使用的。
		if(!basicInfomation.isExpire()&&basicInfomation.isActive()){
			//启动keepSession线程。
			startKeepSession();
			//启动计时线程。
			startOnlineTimeCounter();

		}

		//显示登录信息。
		informationArea.appendText(Constants.MAIN_NAME+":"+basicInfomation.getUserName()+"\n");
		informationArea.appendText(Constants.MAIN_NET_GROUP+":"+basicInfomation.getNetGroupName()+"\n");
		informationArea.appendText(Constants.MAIN_EXPIRE_TIME+":"+basicInfomation.getExpireTime()+"\n");
		
		//如果用户帐号不可用，则显示相关信息。
		if(!basicInfomation.isActive()){
			informationArea.appendText(basicInfomation.getMessage()+"\n");
		}


	}


	/**
	 * 启动一个维护session的线程
	 */
	public void startKeepSession(){
		//取消上一次还未完的维护会话任务。
		if( keepSessionTask != null && keepSessionTask.isRunning() ){
			keepSessionTask.cancel();
		}
		//取消上一次还未完成获取验证码图片的倒计时任务。
		if( timeCounterForGetCaptchaTask != null && timeCounterForGetCaptchaTask.isRunning() ){
			timeCounterForGetCaptchaTask.cancel();
		}

		//创建维护会话任务，并将当前对象设置为监听器，方便接受任务信息。
		keepSessionTask = new KeepSessionTask(openAAAService, 
				loginInfomation.getUserId(), loginInfomation.getTokenString());
		
		keepSessionTask.setGetPictureTime(Constants.GET_CAPTCHA_TIME);

		keepSessionTask.addKeepSessionTaskListener(this);
		Thread t = new Thread(keepSessionTask);
		t.setDaemon(true);
		

		//同时启动获取验证图片时间倒计时线程
		timeCounterForGetCaptchaTask = new TimeCounterForGetCaptchaTask(Constants.GET_CAPTCHA_TIME);
		timeCounterForGetCaptchaTask.addTimeCounterForGetCaptchaTaskListener(this);
		Thread t2 = new Thread( timeCounterForGetCaptchaTask );
		t2.setDaemon(true);
		
		//同时启动维护会话任务和获取验证图片倒计时任务。
		t.start();
		t2.start();



	}

	/**
	 * 启动在线时间计时任务。
	 */
	public void startOnlineTimeCounter(){
		timeCounterForOnlineTask = new TimeCounterForOnlineTask();
		timeCounterForOnlineTask.addTimeCounterForOnlineTaskListener(this);
		Thread t = new Thread(timeCounterForOnlineTask);
		t.setDaemon(true);
		t.start();
	}

	@Override
	public void showMessage(String message) {
		FadeTransition ft = new FadeTransition(Duration.millis(1000), messageLabel);
		ft.setFromValue(0.0);
		ft.setToValue(1);
		ft.play();
		messageLabel.setText(message);

	}

	@Override
	public void handleMessage(String message) {

		Platform.runLater(new ShowMessageThread(message, this));

	}

	@Override
	public void receiveKeepSessionResult(KeepSessionType type) {

		if( type == KeepSessionType.SUCCESS){

			log.debug("keepSession success");

		}

		else if ( type == KeepSessionType.NO_SESSION ){

			log.debug("keepSession no session");
		}

		else if( type == KeepSessionType.TOKEN_ERROR ){

			log.debug("keepSession token error");

		}

		else if( type == KeepSessionType.CANT_CONNECT_SERVER ){

			log.debug("keepSession can't connect server");

			if( timeCounterForOnlineTask != null ){
				timeCounterForOnlineTask.cancel();
			}
		}

		else if( type == KeepSessionType.UNKNOW_ERROR ){

			log.debug("keepSession unknow error");

		}

	}

	@Override
	public void keepSessionFinished() {

		log.debug("keepSession finished");
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				applicationViewManager.showInputTokenView();

			}
		});

		//		applicationViewManager.showInputTokenView();
	}

	@Override
	public void updateOnlineTime(String time) {
		onlineTime = time;
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				onlineTimeLabel.setText(onlineTime);

			}
		});

	}

	@Override
	public void updateHowLongToGetCaptchaTime(long time) {
		getCaptchaTime = time;
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				timeToGetCaptchaLabeltimeToGetCaptchaLabel.setText(TimeFormater.format((int) getCaptchaTime));

			}
		});

	}

}
