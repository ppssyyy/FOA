package com.feng.foa.model;

import javax.xml.datatype.XMLGregorianCalendar;

import cn.edu.nsu.aaa.LoginResultInfo;


/**
 * 保存登陆后基本信息。
 * @author fengyouchao
 *
 */
public class BasicInfomation {
	
	private LoginResultInfo loginResultInfo;
	
	/**
	 * 通过LoginResultInfo构造BasicInfomation对象。
	 * 
	 * @param loginResultInfo LoginResultInfo对象。
	 */
	public BasicInfomation(LoginResultInfo loginResultInfo){
		
		this.loginResultInfo = loginResultInfo;
		
	}
	
	/**
	 * 获取网络套餐名称。
	 * 
	 * @return {@link String}类型的网络套餐名称。
	 */
    public String getNetGroupName() {
        return loginResultInfo.getNetGroupName();
    }

    /**
     * 获取过期时间。
     * 
     * @return {@link XMLGregorianCalendar}类型的过期时间。
     */
    public XMLGregorianCalendar getExpireTime() {
        return loginResultInfo.getExpireTime();
    }

    /**
     * 获取用户的姓名。
     * 
     * @return {@link String}类型的用户的姓名。
     */
    public String getUserName() {
        return loginResultInfo.getUserName();
    }

    /**
     * 获取服务器返回的信息。
     * 
     * @return 服务器返回的{@link String}类型的信息。
     */
    public String getMessage() {
        return loginResultInfo.getMessage();
    }

    /**
     * 判读当前用户是否登陆。
     * 
     * @return 如果已登录返回true，否则返回false。
     */
    public boolean isLogin() {
        return loginResultInfo.isIsLogin();
    }


    /**
     * 判断用户时限是否过期。
     * 
     * @return 过期则返回true，否则返回false。
     */
    public boolean isExpire() {
        return loginResultInfo.isIsExpire();
    }
    
    /**
     * 判断用户是否可用。
     * 
     * @return 可用返回true，不可用返回false。
     */
    public boolean isActive(){
    	return loginResultInfo.getMessage().equals("True");
    }
 


}
