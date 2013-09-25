package com.feng.openaaa.model;

import com.feng.openaaa.util.Language;

/**
 * the class <code>Constant</code> is used to save
 * some constant.
 * 
 * @author fengyouchao
 *
 */
public class Constants {
	
	//fxml file's path.
	public final static String PATH_OF_LOGIN_FXML = "/view/Login.fxml";
	public final static String PATH_OF_MAIN_FXML = "/view/Main.fxml";
	public final static String PATH_OF_INPUT_TOKEN_FXML = "/view/InputToken.fxml";
	public final static String CAPTCHA_PATH = "cache";
	public final static String CAPTCHA_NAME = "token.png";
	
	
	
	public final static String API_VERSION = "1.0.0.0";
	
	
	public final static String BLANK = "";
	public final static String LANGUAGE_PACKAGE_NAME = "language";

	
	public final static String USER_ID = "userId";
	public final static String USER_PASSWORD = "password";
	
	public final static String OPEN_AAA_SERVICE = "openaaaService";
	
	public final static String LOGIN_INFO = "loginInformation";
	
	public final static String APP_VIEW_CONTROLER = "applicationController";
	public static final String FRONT_STAGE = "frontStage";
	public static final String MAIN_CONTROLLER = "mainController";
	public static final String LOGIN_CONTROLLER = "loginController";
	
	public static long GET_CAPTCHA_TIME = 840000;
	
	public final static String MAIN_NAME = Language.getString("main.information.name");
	public final static String MAIN_NET_GROUP = Language.getString("main.information.net.group");
	public final static String MAIN_EXPIRE_TIME = Language.getString("main.information.expire.time");
	
}
