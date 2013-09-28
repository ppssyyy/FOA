package com.feng.foa.controller;

/**
 * 图片展示器，定义显示图片的方法。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public interface PictrueDisplayer {
	
	/**
	 * 显示图片。此方法定义了用户界面上展示图片方法。
	 * 
	 * @param bytes 图片的的byte数组数据。
	 */
	void showPicture(byte[] bytes);

}
