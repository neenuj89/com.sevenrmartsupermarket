package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.PushNotificationsPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;
import com.sevenrmartsupermarket.utilities.ScreenshotUtility;

public class PushNotificationsTest extends Base{

	PushNotificationsPage pushNotificationPage;
	ExcelRead excelRead;
	String actualAlertMessage;
	String expectedAlertMessage="×\n"+ "Alert!\n"+ "Message send successfully";
	boolean resetFlag;
	@Test(groups={"smoke","regresion"})
	public void verifySubmitPushNotification() {
		pushNotificationPage=new PushNotificationsPage(driver);
		pushNotificationPage.launchPushNotification();
		excelRead =new ExcelRead();
		excelRead.setExcelFile("PushNotifications","PushNotifications");
		String title = excelRead.getCellData(1, 0);
		String desc= excelRead.getCellData(1, 1);
		pushNotificationPage.sendPushNotification(title,desc);	
		actualAlertMessage=pushNotificationPage.getActualAlertMessage();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		
	}
	@Test(groups={"smoke","regresion"})
	public void verifyResetPushNotification() {		
		pushNotificationPage=new PushNotificationsPage(driver);
		pushNotificationPage.launchPushNotification();
		pushNotificationPage.resetPushNotification();
		resetFlag=pushNotificationPage.verifyReset();
		Assert.assertTrue(resetFlag);
		
	}
	@Test(groups="regresion")
	public void verifyResetPushNotificationValueEntered() {
		pushNotificationPage=new PushNotificationsPage(driver);
		pushNotificationPage.launchPushNotification();
		excelRead =new ExcelRead();
		excelRead.setExcelFile("PushNotifications","PushNotifications");
		String title = excelRead.getCellData(1, 0);
		String desc= excelRead.getCellData(1, 1);
		pushNotificationPage.resetPushNotification(title,desc);
		resetFlag=pushNotificationPage.verifyReset();
		Assert.assertTrue(resetFlag);
	}
	
}
