package com.feng.openaaa.model;

import javax.xml.datatype.XMLGregorianCalendar;

import cn.edu.nsu.aaa.LoginResultInfo;


/**
 * 
 * @author fengyouchao
 *
 */
public class BasicInfomation {
	
	private LoginResultInfo loginResultInfo;
	
	public BasicInfomation(LoginResultInfo loginResultInfo){
		
		this.loginResultInfo = loginResultInfo;
		
	}
	
    public String getNetGroupName() {
        return loginResultInfo.getNetGroupName();
    }

    public XMLGregorianCalendar getExpireTime() {
        return loginResultInfo.getExpireTime();
    }

    public String getUserName() {
        return loginResultInfo.getUserName();
    }

    public String getMessage() {
        return loginResultInfo.getMessage();
    }

    public boolean isLogin() {
        return loginResultInfo.isIsLogin();
    }



    public boolean isExpire() {
        return loginResultInfo.isIsExpire();
    }
    
    public boolean isActive(){
    	return loginResultInfo.getMessage().equals("True");
    }
 


}
