package com.feng.openaaa.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 
 * @author fengyouchao
 *
 */
public class IPManager {

	public static String getIp(){
		StringBuilder sb = new StringBuilder();
	    try {
	    	Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); 
	        while (en.hasMoreElements()) {
	            NetworkInterface intf = (NetworkInterface) en.nextElement();
	            Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();
	            while (enumIpAddr.hasMoreElements()) {
	                 InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
	                 if (!inetAddress.isLoopbackAddress()  && !inetAddress.isLinkLocalAddress() 
	                		 	&& inetAddress.isSiteLocalAddress()) {
	                	 sb.append(inetAddress.getHostAddress().toString()+"\n");
	                 }
	             }
	          }
	    } catch (SocketException e) {  }
	    return sb.toString();
	}
}
