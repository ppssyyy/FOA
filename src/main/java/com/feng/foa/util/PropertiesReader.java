package com.feng.foa.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author fengyouchao
 *
 */
public class PropertiesReader {
	
	public static Properties readProperties(String path){
		Properties p = null;
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(path));
			p = new Properties();   
			p.load(in); 
			System.out.println(p.get("name"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return p;
	}
	

}
