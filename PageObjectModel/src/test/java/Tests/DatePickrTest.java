package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.DatePickrPage;
import Pages.TablePage;

public class DatePickrTest extends BaseClass{
	DatePickrPage DatePickrPageObj;
	
	@Test
	public void launchDatePicker() {
		DatePickrPageObj =new DatePickrPage(driver);
		DatePickrPageObj.clickOnDatePicker();
		
	}
	@Test
	public void enterDate() {
		DatePickrPageObj =new DatePickrPage(driver);
		DatePickrPageObj.clickOnDatePicker();
		DatePickrPageObj.selectDatePickerDate();
		
	}

}
