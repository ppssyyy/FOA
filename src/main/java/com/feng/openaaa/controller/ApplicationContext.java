package com.feng.openaaa.controller;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @author fengyouchao
 *
 */
public class ApplicationContext {
	
	private static Map<String , Object> map = null;
	
	public static void set(String key,Object object){
		if(map == null){
			map = new HashMap<>();
		}
		map.put(key, object);
	}
	
	public static Object get(String key){
		return map.get(key);
	}
	
	public static Object remove(String key){
		return map.remove(key);
	}
	
	public static void clear(){
		map.clear();
	}

}
