package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertsModalPage {
	WebDriver driver;
	By alertModal =By.xpath("//a[@id='alert-modal']");
	By alertModalHeading= By.xpath("//div[contains(text(),'Bootstrap')]");

	public AlertsModalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAlertModal() {
		WebElement element= driver.findElement(alertModal);
		element.click();
	}
	public String getHeader() {
		WebElement header = driver.findElement(alertModalHeading);
		String actualHeader=header.getText();
		return actualHeader;
	}
}
