package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerPage {
	WebDriver driver;
	By datepicker= By.xpath("//a[contains(text(),'Date Pickers')]");
	
	public DatePickerPage(WebDriver driver) {
		this.driver=driver;
	}
	public void launchDatePIcker() {
		WebElement datapicker = driver.findElement(datepicker);
	}

}
