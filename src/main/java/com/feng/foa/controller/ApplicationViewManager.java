package com.feng.foa.controller;


/**
 * 定义了界面转化的方法。
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface ApplicationViewManager {
	
	/**
	 * 显示输入验证码界面。
	 */
	public void showInputTokenView();
	
	/**
	 * 显示登录界面。
	 */
	public void goToLoginView();
	
	/**
	 * 显示主界面。
	 */
	public void goToMainView();
	
	/**
	 * 关闭前段模窗口
	 */
	public void closeFrontView();
	
	

}
