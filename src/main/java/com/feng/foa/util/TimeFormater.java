package com.feng.foa.util;

/**
 * 格式是时间类。
 * @author fengyouchao
 * @version 1.0
 *
 */
public class TimeFormater {

	/**
	 * 将毫毛的时间格式化未hh:mm:ss格式的字符串。
	 * @param msec 毫秒。
	 * @return 格式化后的时间。
	 */
	public static String format(long msec){
		long seconds = msec/1000;
		long second = seconds%60;
		long minuts = seconds/60;
		long minute = minuts%60;
		long hour = minuts/60;
		String secondStr = append0(second);
		String minuteStr = append0(minute);
		String hourStr = append0(hour);
		String time = hourStr+":"+minuteStr+":"+secondStr;
		
		return time;
	}
	
	private static String append0(long num){
		if(num<10){
			return "0"+num;
		}
		else{
			return num+"";
		}
	}
	

}
