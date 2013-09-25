package com.feng.openaaa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.util.Duration;

import com.feng.openaaa.exception.AuthenticationException;
import com.feng.openaaa.model.BasicInfomation;
import com.feng.openaaa.model.Constants;
import com.feng.openaaa.model.KeepSessionType;
import com.feng.openaaa.model.LoginInfomation;
import com.feng.openaaa.newtask.KeepSessionTask;
import com.feng.openaaa.newtask.LogoutTask;
import com.feng.openaaa.newtask.TimeCounterForGetCaptchaTask;
import com.feng.openaaa.newtask.TimeCounterForOnlineTask;
import com.feng.openaaa.newtask.listener.KeepSessionTaskListener;
import com.feng.openaaa.newtask.listener.LogoutTaskListener;
import com.feng.openaaa.newtask.listener.TimeCounterForGetCaptchaTaskListener;
import com.feng.openaaa.newtask.listener.TimeCounterForOnlineTaskListener;
import com.feng.openaaa.service.OpenAAAService;
import com.feng.openaaa.util.TimeFormater;


/**
 * 主界面控制器
 * 
 * @author fengyouchao
 *
 */
public class MainController implements Initializable,MessageInformer,
KeepSessionTaskListener, LogoutTaskListener, TimeCounterForOnlineTaskListener, 
TimeCounterForGetCaptchaTaskListener{

	private final static Logger log = Logger.getLogger(MainController.class);


	@FXML
	private Label messageLabel;

	@FXML
	private TextArea informationArea;

	@FXML
	private Label onlineTimeLabel;

	@FXML
	private Label timeToGetCaptchaLabeltimeToGetCaptchaLabel;

	public static BooleanProperty needToken;

	private String onlineTime = "00:00:00";
	private long getCaptchaTime = 0;

	private KeepSessionTask keepSessionTask;
	private LogoutTask logoutTask;
	private TimeCounterForOnlineTask timeCounterForOnlineTask;
	private TimeCounterForGetCaptchaTask timeCounterForGetCaptchaTask;

	private OpenAAAService openAAAService;
	private ApplicationViewManager applicationViewManager;
	private LoginInfomation loginInfomation;


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

		//终止keepSession线程
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

		//获取
		BasicInfomation basicInfomation = null;
		try {
			basicInfomation = openAAAService.getBasicInformation();
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("active:"+basicInfomation.isActive());

		if(!basicInfomation.isExpire()&&basicInfomation.isActive()){
			//启动keepSession线程
			startKeepSession();
			//启动计时线程
			startTimeCounter();

		}

		//显示登录信息
		informationArea.appendText(Constants.MAIN_NAME+":"+basicInfomation.getUserName()+"\n");
		informationArea.appendText(Constants.MAIN_NET_GROUP+":"+basicInfomation.getNetGroupName()+"\n");
		informationArea.appendText(Constants.MAIN_EXPIRE_TIME+":"+basicInfomation.getExpireTime()+"\n");

		if(!basicInfomation.isActive()){
			informationArea.appendText(basicInfomation.getMessage()+"\n");
		}


	}


	/**
	 * 启动一个维护session的线程
	 */
	public void startKeepSession(){
		
		if( keepSessionTask != null && keepSessionTask.isRunning() ){
			keepSessionTask.cancel();
		}
		if( timeCounterForGetCaptchaTask != null && timeCounterForGetCaptchaTask.isRunning() ){
			timeCounterForGetCaptchaTask.cancel();
		}
		

		LoginInfomation loginInfomation = (LoginInfomation)
				ApplicationContext.get(Constants.LOGIN_INFO);

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
		
		
		t.start();
		t2.start();



	}

	public void startTimeCounter(){
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
