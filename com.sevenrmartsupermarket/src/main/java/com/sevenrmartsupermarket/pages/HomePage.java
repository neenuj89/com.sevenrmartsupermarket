package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class HomePage {
	
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream ip;
	@FindBy(xpath="//a[@class='d-block']")
	WebElement profileName;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getActualProfileName() {
		String actualProfileName= profileName.getText();
		actualProfileName=actualProfileName.toUpperCase();
		return actualProfileName;
		
	}
	public String getExpectedProfileName() {
		String expectedProfileName=properties.getProperty("username");
		expectedProfileName=expectedProfileName.toUpperCase();
		return expectedProfileName;
	}
	public String getExpectedProfileName(String expectedName) {
		String expectedProfileName=expectedName.toUpperCase();
		return expectedProfileName;
	}
	
	

}
