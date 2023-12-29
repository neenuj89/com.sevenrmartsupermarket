package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Actions actions;
	Select select;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		driver = this.driver;
	}

	public void mouseMoveTo(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();

	}

	public void select_ByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	public void select_ByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void scrollAndClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		int y = 0;
		while (!(isClicked(element))) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 2;
			}
	}

	public boolean isClicked(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	

}
