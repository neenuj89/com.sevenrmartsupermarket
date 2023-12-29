package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base{
	ManageDeliveryBoyPage manageDeliveryBoyPage;
	
	
	@Test
	public void launchManageDeliveryBoy() {
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.launchManageDeliveryBoy();
		manageDeliveryBoyPage.editDeliveryBoy("client29/12/2023 11:41:58");
	}

}
