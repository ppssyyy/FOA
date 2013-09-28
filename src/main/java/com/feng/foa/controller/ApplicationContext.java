package com.feng.foa.controller;

import java.util.HashMap;
import java.util.Map;


/**
 * 应用上下文,存储全局对象。
 * @author fengyouchao
 * @version 1.0
 *
 */
public class ApplicationContext {
	
	private static Map<String , Object> map = null;
	
	/**
	 * 将要保存的对象保存再<code>ApplicationContext</code>中。
	 * 
	 * @param key {@link String}
	 * @param object {@link Object}
	 */
	public static void set(String key,Object object){
		if(map == null){
			map = new HashMap<>();
		}
		map.put(key, object);
	}
	
	
	/**
	 * 通过key获取保存再<code>ApplicationContext</code>中的对象。
	 * @param key {@link String}
	 * @return {@link Object}
	 */
	public static Object get(String key){
		return map.get(key);
	}
	
	/**
	 * 通过键值从<code>ApplicationContext</code>移除对象
	 * @param key {@link String}
	 * @return {@link Object}
	 */
	public static Object remove(String key){
		return map.remove(key);
	}
	
	
	/**
	 * 清空<code>ApplicationContext</code>中保存的对象。
	 */
	public static void clear(){
		map.clear();
	}

}
