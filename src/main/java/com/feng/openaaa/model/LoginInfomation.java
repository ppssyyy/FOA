package com.feng.openaaa.model;

/**
 * 
 * @author fengyouchao
 *
 */
public class LoginInfomation {
	
	private String userId = "-";
	private String password = "-";
	private String APIVersion = Constants.API_VERSION;
	private String ipAddress = "-";
	private String tokenString = "-";
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAPIVersion() {
		return APIVersion;
	}
	public void setAPIVersion(String aPIVersion) {
		APIVersion = aPIVersion;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getTokenString() {
		return tokenString;
	}
	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}
	
	

}
