package com.feng.openaaa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

import com.feng.openaaa.model.Constants;
import com.feng.openaaa.service.OpenAAAServiceImp;
import com.feng.openaaa.util.Language;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 应用界面主控器，管理各个界面的装换
 * 
 * @author fengyouchao
 * @version 1.0
 * @since jDK7
 *
 */
public class ApplicationController extends Application implements ApplicationViewManager {

	//主窗口stage(loginView/mainView)
	private Stage stage;
	
	
	private LoginController controller;
	
	private MainController mainController;

	
	/**
	 * initialize.
	 * 
	 * @param primaryStage the primary stage of the view(loignView,MainView).
	 */
	public void init(Stage primaryStage){
		//初始化国际化配置
		Language language = new Language(Constants.LANGUAGE_PACKAGE_NAME);
		language.setLocalLanguage();
		stage = primaryStage;
		ApplicationContext.set(Constants.APP_VIEW_CONTROLER, this);
		ApplicationContext.set(Constants.OPEN_AAA_SERVICE, new OpenAAAServiceImp());
		goToLoginView();
	}


	@Override
	public void start(Stage primaryStage) {
		init(primaryStage);
		primaryStage.show();
	}

	/**
	 * show the view to input token.
	 */
	@Override
	public void showInputTokenView(){
		showView(Constants.PATH_OF_INPUT_TOKEN_FXML);
	}

	/**
	 * go to MainView.
	 */
	@Override
	public void goToMainView(){
		try {
			mainController = (MainController) replaceSceneContent(Constants.PATH_OF_MAIN_FXML);
			if(controller!=null){
				
				controller.setApplication(this);
			}      
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * go to LoginView.
	 */
	@Override
	public void goToLoginView(){
		try {
			controller = (LoginController) replaceSceneContent(Constants.PATH_OF_LOGIN_FXML);
			if(controller!=null){
				
				controller.setApplication(this);
			}      
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * replace a content of a scene.
	 * 
	 * @param fxml the path of the fxml file.
	 * @return the instance of <code>Initializable</code>
	 * @throws Exception
	 */
	private Initializable replaceSceneContent(String fxml) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		InputStream in = ApplicationController.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(ApplicationController.class.getResource(fxml));
		loader.setResources(ResourceBundle.getBundle(Constants.LANGUAGE_PACKAGE_NAME));
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		}finally {
			in.close();
		} 
		stage.centerOnScreen();
		Scene scene = new Scene(page);
		stage.setScene(scene);
		stage.sizeToScene();


		return (Initializable) loader.getController();
	}

	/**
	 * show a model view.
	 * 
	 * @param fxmlPath the path of the fxml file.
	 */
	public void showView(String fxmlPath){
		final Stage stage = new Stage();

		ApplicationContext.set(Constants.FRONT_STAGE, stage);
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(fxmlPath),ResourceBundle.getBundle(Constants.LANGUAGE_PACKAGE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(this.stage);
		stage.show();
	}

	/**
	 * the enter of the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}


	public LoginController getController() {
		return controller;
	}


	public MainController getMainController() {
		return mainController;
	}


	@Override
	public void closeFrontView() {
		((Stage)ApplicationContext.get(Constants.FRONT_STAGE)).close();
		
	}




}
