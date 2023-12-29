package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class AdminUserTest extends Base{
AdminUserPage adminUserPage;
String expectedAdminUserPageTitle="Admin Users";
String actualAdminUserPageTitle, actualAdminUserAlertMessage;
String expectedAdminUserAlertMessage="×\n"+ "Alert!\n"+ "User Created Successfully";
ExcelRead excelRead;
@Test
public void verifyAdminUserPageTitle() {
	adminUserPage= new AdminUserPage(driver);
	adminUserPage.launchAdminUserPage();
	actualAdminUserPageTitle=adminUserPage.getAdminUserPageTitle();
	Assert.assertEquals(actualAdminUserPageTitle, expectedAdminUserPageTitle);
}
@Test
public void verifyNewAdminUser() {
	adminUserPage= new AdminUserPage(driver);
	adminUserPage.launchAdminUserPage();
	excelRead =new ExcelRead();
	excelRead.setExcelFile("NewUserCredentials","NewUSerCredentials");
	String newAdminUsername = excelRead.getCellData(3, 0);
	String newAdminPassword= excelRead.getCellData(3, 1);
	String newAdminUserType= excelRead.getCellData(3, 2);
	adminUserPage.addNewAdminUser(newAdminUsername,newAdminPassword,newAdminUserType);
	actualAdminUserAlertMessage= adminUserPage.getActualUserCreatedAlertMessage();
	Assert.assertEquals(actualAdminUserAlertMessage, expectedAdminUserAlertMessage);
}
@Test
public void verifyResetNewAdminUser() {
	adminUserPage= new AdminUserPage(driver);
	adminUserPage.launchAdminUserPage();
	excelRead =new ExcelRead();
	excelRead.setExcelFile("NewUserCredentials","NewUSerCredentials");
	String newAdminUsername = excelRead.getCellData(3, 0);
	String newAdminPassword= excelRead.getCellData(3, 1);
	String newAdminUserType= excelRead.getCellData(3, 2);
	adminUserPage.resetNewAdminUser(newAdminUsername, newAdminPassword, newAdminUserType);
	boolean userNameIsDisplayed= adminUserPage.userNameIsDisplayed();
	Assert.assertFalse(userNameIsDisplayed);
	
}
	
}
