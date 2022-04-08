package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginPage;

@Listeners(com.listeners.ListenrEx.class)
public class LoginTest extends BaseClass {

	
	public LoginPage lp=null;
	
	@BeforeSuite
	public void setup() {
		initialization();
		lp=new LoginPage(driver);
	}
	
	@Test
	public void loginTest() {
		lp.loginToApplication();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	@Test
	public void failedDashTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//abc")).isDisplayed());
	}
}
