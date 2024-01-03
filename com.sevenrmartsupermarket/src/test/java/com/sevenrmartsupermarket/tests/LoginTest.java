package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.ValidUserLogins;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;




public class LoginTest extends Base{
	
	LoginPage loginPage;
	HomePage homepage;
	ExcelRead excelRead;
	String actualProfileName;
	String expectedProfileName;
	@Test(groups = "regression")
	public void verifyLogin() {
		loginPage= new LoginPage(driver);
		homepage =new HomePage(driver);
		//loginPage.login();///credentials will be fetched from config.properties
		loginPage.login("jithu"," hghg");	//manually credentials are provided
		actualProfileName=homepage.getActualProfileName();
		//expectedProfileName=homepage.getExpectedProfileName();//expected value will be fetched from config 
		expectedProfileName=homepage.getExpectedProfileName("jithu");
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}
	@Test(groups = "regresion")
	public void verifyLoginUsingExcel() {
		loginPage= new LoginPage(driver);
		homepage =new HomePage(driver);
		excelRead =new ExcelRead();
		excelRead.setExcelFile("LoginData","LoginCredentials");
		String userName = excelRead.getCellData(1, 0);
		String pass = excelRead.getCellData(1, 1);
		loginPage.login(userName, pass);
		actualProfileName=homepage.getActualProfileName();
		expectedProfileName=homepage.getExpectedProfileName(userName);
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}
	@Test(groups = "smoke",dataProvider = "Valid User Credentials",dataProviderClass = ValidUserLogins.class)
	public void verifyLoginUsingDataProvider(String username, String password) {
		loginPage= new LoginPage(driver);
		homepage =new HomePage(driver);
		loginPage.login(username, password);
		actualProfileName=homepage.getActualProfileName();
		expectedProfileName=homepage.getExpectedProfileName(username);
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}
}
