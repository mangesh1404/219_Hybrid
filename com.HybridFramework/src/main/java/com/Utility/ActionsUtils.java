package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BaseClass;

public class ActionsUtils extends BaseClass {

	public void rightClick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public static void moveToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static void main(String[] args) {
		initialization();
		driver.navigate().to("https://www.carmax.com/");
		WebElement moreLink = driver.findElement(By.xpath("//span[text()='More']"));
		moveToElement(moreLink);
	}
	
}
