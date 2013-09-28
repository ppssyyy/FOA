package com.feng.foa.model;

/**
 * 保存登录信息。用于登陆或登录后取得相关数据。
 * 
 * @author fengyouchao
 * @version 1.0
 *
 */
public class LoginInfomation {
	
	private String userId = "-";
	private String password = "-";
	private String APIVersion = Constants.API_VERSION;
	private String ipAddress = "-";
	private String tokenString = "-";
	
	/**
	 * 获取用户ID。
	 * 
	 * @return 用户ID。
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置用户ID。
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取用户密码。
	 * 
	 * @return 密码。
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置用户密码。
	 * 
	 * @param password 密码。
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取OpenAAA API 版本号。
	 * 
	 * @return OpenAAA API 版本号。
	 */
	public String getAPIVersion() {
		return APIVersion;
	}
	
	/**
	 * 设置OpenAAA API 版本号。
	 * 
	 * @param APIVersion OpenAAA API 版本号。
	 */
	public void setAPIVersion(String APIVersion) {
		this.APIVersion = APIVersion;
	}
	
	/**
	 * 获取IP地址。
	 * 
	 * @return IP地址。
	 */
	public String getIpAddress() {
		return ipAddress;
	}
	
	/**
	 * 设置IP地址。
	 * 
	 * @param ipAddress 
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	/**
	 * 获取验证码字符。
	 * 
	 * @return 验证码字符。
	 */
	public String getTokenString() {
		return tokenString;
	}
	
	/**
	 * 设置验证码字符。
	 * 
	 * @param tokenString 验证码字符。
	 */
	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}
	
	

}
