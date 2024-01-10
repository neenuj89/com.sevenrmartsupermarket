package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	LoginPage loginpage;
	
	@FindBy(xpath="//li[@class='nav-item']//p[contains(text(),'Manage Delivery Boy')]") WebElement manageDeliveryBoyLink;
	//@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']//li[13]") WebElement manageDeliveryBoyLink;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody/tr/td[1]") List <WebElement> nameColumnDeliveryBoyList;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody/tr[3]/td[8]//a[1]") WebElement editDeliveryBoy;
	
	GeneralUtility generalUtility;
	PageUtility pageUtility;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void launchManageDeliveryBoy() {
		loginpage=new LoginPage(driver);
		loginpage.login();
		clickOnManageDeliveryBoy();
	}
	public void clickOnManageDeliveryBoy() {
		manageDeliveryBoyLink.click();
	}
	
	public void editDeliveryBoy(String deliveryBoyName) {
		int index=0;
		generalUtility= new GeneralUtility(driver);
		pageUtility =new PageUtility(driver);
		List<String> deliveryBoyNames = new ArrayList<String>();
		deliveryBoyNames= generalUtility.getTextOfElements(nameColumnDeliveryBoyList);
		for(index=0;index<deliveryBoyNames.size();index++) {
			if(deliveryBoyName.equals(deliveryBoyNames.get(index))) {
				index++;
				break;
			}
		}
		WebElement deliveryBoytobeEdited= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody/tr["+index+"]/td[8]//a[1]"));		
		WaitUtility.waitForButtonTobeClickable(driver, deliveryBoytobeEdited);
		pageUtility.scrollAndClick(deliveryBoytobeEdited);//
	}
}
