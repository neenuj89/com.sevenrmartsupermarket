package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class PushNotificationsPage {
	WebDriver driver;
	String resetTitle,resetDesc;
	LoginPage loginpage;
	@FindBy(xpath = "//a[@class=' nav-link']//p[contains(text(),'Push Notifications')]")
	WebElement pushNotification;
	@FindBy(xpath = "//input[@id='title']")
	WebElement titleElement;
	@FindBy(xpath = "//input[@id='description']")
	WebElement descriptionElement;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButtton;
	@FindBy(xpath = "//a[contains(text(),'Reset')]")
	WebElement resetButtton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement pushNotificationSucessAlertbox;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchPushNotification() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnPushNoyification();

	}
	public void clickOnPushNoyification() {
		pushNotification.click();
	}

	public void enterTitle(String title) {
		titleElement.sendKeys(title);
	}

	public void enterDescription(String description) {
		descriptionElement.sendKeys(description);
	}

	public void submitPushNotification() {
		WaitUtility.waitForButtonTobeClickable(driver, submitButtton);
		submitButtton.click();
	}

	public void resetPushNotification() {
		resetButtton.click();
	}

	public void sendPushNotification(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		submitPushNotification();
	}
	public String getActualAlertMessage() {
		return pushNotificationSucessAlertbox.getText();
	}
	public String getTitle() {
		return titleElement.getText();
	}
	public String getDescription() {
		return descriptionElement.getText();
	}
	public boolean verifyReset() {
		resetTitle= getTitle();
		resetDesc=getDescription();		
		if((resetTitle.isBlank())&& resetDesc.isBlank()) {
			return true;
		}
		return false;
	}
	public void resetPushNotification(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		resetPushNotification();
		
	}

}
