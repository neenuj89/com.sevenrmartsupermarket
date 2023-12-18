package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Utility;

public class TablePage {
	WebDriver driver;
	Utility utilObj =new Utility();
	//By table= By.xpath("//a[contains(text(),'Table')]");
	
	@FindBy(xpath="//a[contains(text(),'Table')]")
	WebElement table;
	
	@FindBy(xpath="//div[contains(text(),'Table with Pagination Example')]")
	WebElement tableHeader;
	
	@FindBy(xpath="//table//tbody//tr/td[1]")
	List<WebElement> nameColumn;
	
	public TablePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);/// to initialize driver
	}
	public void clickOnTable() {	
		table.click();		
	}
	public String getTableHeader() {		
		return tableHeader.getText();
	}
	public List<String> printAllNames() {
		
	 return utilObj.getTextOfElements(nameColumn);
		
	}
	public String getOffice(String personName) {
		List<String> nameList = new ArrayList<String>();
		nameList =utilObj.getTextOfElements(nameColumn);
		int index =0;
		for(index=0;index<nameList.size();index++) {
			if(personName.equals(nameList.get(index))) {
				index++;
				break;
				
			}
		}
		WebElement ofcElement =driver.findElement(By.xpath("//table//tbody//tr["+index+"]/td[3]"));
		return ofcElement.getText();
	}

}
