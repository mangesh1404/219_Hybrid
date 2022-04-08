package com.Utility;

import java.io.FileInputStream;
import java.util.Properties;

import com.sun.org.apache.regexp.internal.recompile;

public class PropertiesUtils {

	public static FileInputStream fis =null;
	public static Properties prop=null;
	
	public static String readProperty(String key) {
		prop=new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		
		System.out.println(readProperty("browser"));
		
		
	}
}
