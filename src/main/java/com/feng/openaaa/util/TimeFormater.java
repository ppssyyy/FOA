package com.feng.openaaa.util;


public class TimeFormater {

	public static String format(int msec){
		int seconds = msec/1000;
		int second = seconds%60;
		int minuts = seconds/60;
		int minute = minuts%60;
		int hour = minuts/60;
		String secondStr = append0(second);
		String minuteStr = append0(minute);
		String hourStr = append0(hour);
		String time = hourStr+":"+minuteStr+":"+secondStr;
		
		return time;
	}
	
	private static String append0(int num){
		if(num<10){
			return "0"+num;
		}
		else{
			return num+"";
		}
	}
	

}
