package com.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.sun.org.apache.bcel.internal.classfile.Field;

import sun.util.calendar.BaseCalendar;

public class DriverUtils extends BaseClass{

	
	public static String getScreenshot(String name) {
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static void ScrollForElement(WebElement element) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void main(String[] args) {
		initialization();
		driver.navigate().to("https://www.amazon.in/");
		WebElement footer_logo= driver.findElement(By.xpath("//a[@href='/ref=footer_logo']"));
		ScrollForElement(footer_logo);
		WebElement header_logo=driver.findElement(By.id("nav-logo-sprites"));
		ScrollForElement(header_logo);
	}
	
	
}
