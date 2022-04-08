package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.Utility.PropertiesUtils;

public class BaseClass {

	public static WebDriver driver=null;
	
	public static Logger log = Logger.getLogger("BaseClass");
	public static void initialization() {
		log.info("reading property file for browser name");
		String browser= PropertiesUtils.readProperty("browser");
		log.info("browser found in the file as "+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			log.info("user launching chrome browser");
			System.setProperty("webdriver.chrome.driver","D:/chromedriver.exe");
			driver= new ChromeDriver();
			log.info("user launched chrome browser");
		}
		if(browser.equalsIgnoreCase("firefox")) {
			log.info("user launching firefox browser");
			System.setProperty("webdriver.gecko.driver","D:/geckodriver.exe");
			driver= new FirefoxDriver();
			log.info("user launched firefox browser");
		}
		log.info("maximizing browser window");
		driver.manage().window().maximize();
		log.info("applying waits on the browser");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		log.info("launching JBK offline application");
		driver.get(PropertiesUtils.readProperty("url"));
	}
	
	
}
