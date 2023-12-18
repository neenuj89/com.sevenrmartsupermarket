package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.AlertsModalPage;

public class AlertsModalTest extends BaseClass{
	AlertsModalPage alertmodalPage;
	String expectedHeading="Bootstrap Alert";
	@Test
	public void openAlertModal() {
		alertmodalPage = new AlertsModalPage(driver);
		alertmodalPage.clickOnAlertModal();
	}
	@Test
	public void verifyHeader() {
		alertmodalPage = new AlertsModalPage(driver);
		alertmodalPage.clickOnAlertModal();
		String actualHeader =alertmodalPage.getHeader();
		Assert.assertEquals(actualHeader, expectedHeading);
	}

}
