package com.feng.openaaa.controller;

import java.net.URL;
import java.util.ResourceBundle;


import org.apache.log4j.Logger;

import com.feng.openaaa.model.Constants;
import com.feng.openaaa.model.LoginInfomation;
import com.feng.openaaa.newtask.CheckUpdateTask;
import com.feng.openaaa.newtask.listener.CheckUpdateTaskListener;
import com.feng.openaaa.service.OpenAAAService;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;


/**
 * 
 * @author fengyouchao
 *
 */
public class LoginController implements Initializable,MessageInformer,
			CheckUpdateTaskListener{

	private final static Logger log = Logger.getLogger(LoginController.class);

	@FXML
	private TextField acField;					//帐号文本框
	
	@FXML
	private PasswordField passwordField;		//密码输入框
	
	@FXML
	private Button acClearButton;				//帐号文本框清空按钮
	
	@FXML
	private Button pwClearButton;				//密码输入框清空按钮
	
	@FXML
	private Label messageLabel;					//显示提示信息的label

	private ApplicationController application;					//界面转换主控器
	
	private CheckUpdateTask checkUpdateTask;
	
	private ApplicationViewManager applicationViewManager;
	private OpenAAAService openAAAService;

	
	@FXML
	public void loginAction(ActionEvent event){
		

		
		String ac = acField.getText().trim();
		String password = passwordField.getText().trim();

		
		//检查空输入
		if(ac.equals("")){
			showMessage("帐号不能为空");
			return;
		}
		if(password.equals("")){
			showMessage("密码不能为空");
			return;
		}
		
		LoginInfomation loginInfomation = new LoginInfomation();
		loginInfomation.setUserId(ac);
		loginInfomation.setPassword(password);
		
		//存储必要的数据
		ApplicationContext.set(Constants.USER_ID, ac);
		ApplicationContext.set(Constants.USER_PASSWORD, password);
		ApplicationContext.set(Constants.LOGIN_INFO, loginInfomation);
		
		applicationViewManager.showInputTokenView();
		
	}


	@FXML
	public void clearAction(ActionEvent event){

		if(event.getSource()==acClearButton){
			acField.setText("");
			acClearButton.setVisible(false);
		}
		else if(event.getSource()==pwClearButton){
			passwordField.setText("");
			acClearButton.setVisible(false);
		}
	}


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		
		ApplicationContext.set(Constants.LOGIN_CONTROLLER, this);
		
		applicationViewManager = ((ApplicationViewManager)ApplicationContext.get(
				Constants.APP_VIEW_CONTROLER));
		openAAAService = (OpenAAAService) ApplicationContext.get(Constants.OPEN_AAA_SERVICE);

		initTextFieldAndClearButton(acField, acClearButton);
		initTextFieldAndClearButton(passwordField, pwClearButton);

		/*
		 * 检查更新
		 */
		checkUpdateTask = new CheckUpdateTask(openAAAService);
		checkUpdateTask.addCheckUpdateTaskListener(this);
		Thread t = new Thread( checkUpdateTask );
		t.start();

		acField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, 
					String oldValue, String newValue) {
//				acField.getContextMenu().show(acField, Side.BOTTOM, 0, 0);
			}
		});


	}

	public void initTextFieldAndClearButton(final TextField textField,final Button button){
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				button.setVisible(textField.getText().length() != 0);
			}
		});
	}

	public ApplicationController getApplication() {
		return application;
	}

	public void setApplication(ApplicationController application) {
		this.application = application;
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
		log.debug("recevie message:"+message);
		Platform.runLater(new ShowMessageThread(message,this));
	}
	




}
