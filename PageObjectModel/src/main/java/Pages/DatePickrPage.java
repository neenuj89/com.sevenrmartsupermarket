package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePickrPage {
	WebDriver driver;

	@FindBy(xpath="//a[contains(text(),'Date Pickers')]")
	WebElement datepicker;
	
	@FindBy(xpath="//input[@id='single-input-field']")
	WebElement enterDate;
	
	@FindBy(xpath="//input[@id='single-input-field2']")
	WebElement dateRangePicker;
	
	@FindBy(xpath="//table//thead//tr//th[@class='prev']")
	WebElement prevButton;
	@FindBy(xpath="(//table//thead//tr[2]//th[3][@class='next'])[1]")
	WebElement nextButton;
	@FindBy(xpath="(//table//thead//tr//th[@class='datepicker-switch'])[1]")
	WebElement monthElement;
	
	public DatePickrPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);/// to initialize driver
	}

	public void clickOnDatePicker() {
		datepicker.click();

	}
	
	public void selectDatePickerDate() {
		enterDate.click();
		String date ="24/11/2000";
		String arr[]=date.split("/");
		String day =arr[0];
		String monthIndex= arr[1];
		String year=arr[2];
		String month="";
		int m= Integer.parseInt(monthIndex);
		int y =Integer.parseInt(year);
		switch (m) {
		case 01:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
		}
		String month_year= month+" "+year;
		System.out.println(month_year);
		while(true) {
			String currentMonth=monthElement.getText();
			if(currentMonth.equals(month_year)) {
				break;
			}
			else if(m<12 && y<=2023) {
				prevButton.click();
				
			}
			else if(y>2023) {
				nextButton.click();
				
			}
			
		}
		WebElement dayElement = driver.findElement(By.xpath("//table//tbody//tr//td[contains(text(),'"+day+"') and @class='day']"));
		dayElement.click();
	}
	
}
