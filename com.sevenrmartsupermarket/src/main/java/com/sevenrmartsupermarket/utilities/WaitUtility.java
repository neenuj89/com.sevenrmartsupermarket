package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT=10;
	public static final long EXPLICIT_WAIT=20;
	public static WebDriverWait wait;
	
	public static void waitForButtonTobeClickable(WebDriver driver, WebElement element) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitforVisibilityOfElemenet(WebDriver driver,  String xPath) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
	}
}
