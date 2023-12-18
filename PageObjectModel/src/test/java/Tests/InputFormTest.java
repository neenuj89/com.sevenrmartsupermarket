package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.InputFormPage;

public class InputFormTest extends BaseClass {

	InputFormPage inputform;

	@Test
	public void launchInputForm() {
		inputform = new InputFormPage(driver);
		inputform.clickOnInputForm();
	}
	@Test
	public void verifyButtonText() {
		String actualText;
		String expecetdText="Show Message";
		inputform= new InputFormPage(driver);
		inputform.clickOnInputForm();
		actualText=inputform.getShowButtonText();
		Assert.assertEquals(actualText, expecetdText);
	}
}
