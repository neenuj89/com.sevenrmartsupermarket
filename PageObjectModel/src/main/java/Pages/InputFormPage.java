package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Utility;

public class InputFormPage {
	WebDriver driver;
 Utility utilityObj = new Utility();
	By inputFormButton = By.xpath("//a[contains(text(),'Input')]");
	By shoMessageButton = By.xpath("//button[@id='button-one']");

	public InputFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnInputForm() {
		WebElement element = driver.findElement(inputFormButton);
		element.click();
	}
	public String getShowButtonText() {
		WebElement showMsgButton = driver.findElement(shoMessageButton);
		String butttonText =showMsgButton.getText();
		String attirbutevalue= utilityObj.get_attirbute(showMsgButton,"id");
		System.out.println(attirbutevalue);
		
		return butttonText;
	}
}
