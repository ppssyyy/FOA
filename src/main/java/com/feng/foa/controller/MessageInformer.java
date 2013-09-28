package com.feng.foa.controller;

/**
 * 信息通知器，定义了显示提示的方法。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface MessageInformer {
	
	/**
	 * 显示一条{@link String}类型的提示信息。此方法定义了在用户界面显示文本信息的方法。
	 * 
	 * @param message 需要显示{@link String}类型的信息。 
	 */
	void showMessage(String message);

}
