package com.feng.foa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.feng.foa.model.Constants;
import com.feng.foa.model.KeepSessionType;
import com.feng.foa.model.LoginInfomation;
import com.feng.foa.model.LoginResultType;
import com.feng.foa.newtask.GetCaptchaTask;
import com.feng.foa.newtask.LoginTask;
import com.feng.foa.newtask.TestKeepSessionTask;
import com.feng.foa.newtask.listener.GetCaptchaTaskListener;
import com.feng.foa.newtask.listener.LoginTaskListener;
import com.feng.foa.newtask.listener.TestKeepSessionTaskListener;
import com.feng.foa.service.OpenAAAService;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;


/**
 * 验证码输入窗口的控制器。它有两种行为:
 * <ul>
 * 	<li>登录验证码输入</li>
 * 	<li>维护会话验证码输入</li>
 * </ul>
 * @author fengyouchao
 * @version 1.0
 * @since JDK7
 *
 */
public class InputTokenController implements Initializable,MessageInformer,
PictrueDisplayer,GetCaptchaTaskListener,LoginTaskListener, TestKeepSessionTaskListener{

	private final static Logger log = Logger.getLogger(InputTokenController.class);

	@FXML
	private ImageView tokenView;
	@FXML
	private TextField tokenField;
	@FXML
	private Label messageLabel;
	@FXML
	private Button button;

	private LoginTask loginTask;


	private GetCaptchaTask getCaptchaTask;
	private TestKeepSessionTask testKeepSessionTask;

	private OpenAAAService openAAAService;
	private LoginInfomation loginInfomation;
	private ApplicationViewManager applicationViewManager;


	/**
	 * 响应登录按钮的方法。
	 * 当用处于户登陆状态时，它执行登录，
	 * 当用户已经登陆，它将执行维护会话。
	 * @param event {@link ActionEvent}
	 */
	@FXML
	public void loginAction( ActionEvent event ){

		String token = tokenField.getText().trim();

		loginInfomation.setTokenString(token);

		if(token == null || token.equals("")){
			showMessage("不能为空");
			return;
		}

		//判断是否是否当登陆
		//没有登录则当前状态为登录状态
		if( !openAAAService.isLogin() ){

			loginInfomation.setTokenString(token);

			loginTask = new LoginTask( openAAAService, loginInfomation );
			loginTask.addLoginTaskListener(this);
			new Thread(loginTask).start();

		}
		//若已经登录，则当前状态为keepSession状态
		else{
			String id = (String) ApplicationContext.get(Constants.USER_ID);
			//验证验证码
			testKeepSessionTask = new TestKeepSessionTask(openAAAService, id, token);
			testKeepSessionTask.addTestKeepSessionTaskListener(this);
			Thread t = new Thread(testKeepSessionTask);
			t.setDaemon(true);
			t.start();
			//开始新一轮的KeepSession
		}

		//系统login返回的错误信息如下:
		//系统已升级, 目前必须使用的OpenAAA版本为: 1.0.0.0
		//UserID, UserPW, UserIP, Token 不能为空.
		//客户端IP与实际IP不符, 你的实际IP为: 10.101.3.90
		//Token输入不正确.
		//用户名或密码不正确!
	}

	/**
	 * 响应用户点击验证码图片的方法。
	 * 它将会请求一个新的验证码图片。
	 * @param event
	 */
	@FXML
	public void tokenViewClickedAction(MouseEvent event){
		getCaptcha();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		applicationViewManager = (ApplicationViewManager)
				ApplicationContext.get(Constants.APP_VIEW_CONTROLER);

		openAAAService = (OpenAAAService)ApplicationContext.get(Constants.OPEN_AAA_SERVICE);

		loginInfomation = 
				(LoginInfomation)(ApplicationContext.get(Constants.LOGIN_INFO));

		getCaptcha();

	}

	/**
	 * 启动一个获取验证图片的任务。
	 */
	public void getCaptcha(){
		getCaptchaTask = new GetCaptchaTask( openAAAService );
		getCaptchaTask.addGetCaptchaTaskListener(this);
		Thread t = new Thread(getCaptchaTask);
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
	public void showPicture(byte[] pictureBytes) {
		File file = new File(Constants.CAPTCHA_PATH);
		file.mkdirs();
		file = new File(Constants.CAPTCHA_PATH+"/"+Constants.CAPTCHA_NAME);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(pictureBytes);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Image image = new Image(fis);

		tokenView.setImage(image);

	}

	@Override
	public void handleMessage(String message) {
		Platform.runLater(new ShowMessageThread(message,this));

	}

	@Override
	public void GetCapchaSuccess(byte[] bytes) {
		showPicture(bytes);
	}

	@Override
	public void receiveLoginResult(LoginResultType type) {

		if( type == LoginResultType.SUCCESS ){

			log.debug("登录成功");

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					applicationViewManager.closeFrontView();
					applicationViewManager.goToMainView();

				}
			});

		}
		else if( type == LoginResultType.ERROR_TOKEN ){

			log.debug("验证码错误");

		}
		else if( type == LoginResultType.CANT_CONNECT_SERVER ){

			log.debug("登陆失败，网络错误");

		}
		else if( type == LoginResultType.USER_ERROR ){

			log.debug("用户名或密码错误");
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					applicationViewManager.closeFrontView();
					LoginController loginController = 
							(LoginController) ApplicationContext.get(Constants.LOGIN_CONTROLLER);
					loginController.showMessage("用户名或密码错误");

				}
			});


		}
		else if( type == LoginResultType.ERROR_IP ){
			log.debug("ip错误");
		}

	}

	@Override
	public void testKeepSessionAction(KeepSessionType type) {
		if( type== KeepSessionType.SUCCESS ){
			Platform.runLater(new Runnable() {

				@Override
				public void run() {

					applicationViewManager.closeFrontView();
					MainController mainController = 
							(MainController) ApplicationContext.get(Constants.MAIN_CONTROLLER);
					mainController.startKeepSession();
				}
			});

		}

	}


}
