package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {

	WebDriver driver;
	LoginPage loginpage;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminUserLink;
	@FindBy(xpath="//h1[@class='m-0 text-dark']") WebElement adminUserPageTitle;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//input[@id='username']") WebElement adminUsername;
	@FindBy(xpath="//input[@id='password']") WebElement adminPassword;
	@FindBy(xpath="//select[@id='user_type']") WebElement userType;
	@FindBy(xpath="//button[@name='Create']") WebElement saveNewAdminUserbutton;
	@FindBy(xpath="(//a[@class='btn btn-default btn-fix'])[2]") WebElement resetNewAdminUSerbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement userCreatedAlert;
	
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void launchAdminUserPage() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		adminUserLink.click();
	}
	public String getAdminUserPageTitle() {
		return adminUserPageTitle.getText();
	}
	public void clickNewButton() {
		newButton.click();
	}
	public void clickSaveNewAdminUSer() {
		saveNewAdminUserbutton.click();
	}
	public void clickResetNewAdminUser() {
		resetNewAdminUSerbutton.click();
	}
	public void addNewAdminUser(String newAdminUsername,String newAdminPassword,String newAdminUserType) {
		clickNewButton();
		adminUsername.sendKeys(newAdminUsername);
		adminPassword.sendKeys(newAdminPassword);
		Select userTypeSelect = new Select(userType);
		userTypeSelect.selectByValue(newAdminUserType);
		clickSaveNewAdminUSer();
	}
	public String getActualUserCreatedAlertMessage() {
		return userCreatedAlert.getText();
	}
	public void resetNewAdminUser(String newAdminUsername,String newAdminPassword,String newAdminUserType) {
		clickNewButton();
		adminUsername.sendKeys(newAdminUsername);
		adminPassword.sendKeys(newAdminPassword);
		Select userTypeSelect = new Select(userType);
		userTypeSelect.selectByValue(newAdminUserType);
		clickResetNewAdminUser();
	}
	public boolean userNameIsDisplayed() {
		return adminUsername.isDisplayed();
	}
	
	

}
