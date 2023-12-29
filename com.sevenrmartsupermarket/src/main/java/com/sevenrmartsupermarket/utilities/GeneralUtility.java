package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {

	WebDriver driver;
	public GeneralUtility(WebDriver driver) {
		driver=this.driver;
	}
	
	public String get_Attribute(WebElement element, String attribute) {
	return element.getAttribute(attribute);
		
	}
	public String get_cssValue(WebElement element, String cssProperties) {
		return element.getCssValue(cssProperties);
		
	}
	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}
	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}
	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}
	public List<String> getTextOfElements(List<WebElement> elements) {
		List <String> data =new ArrayList<String>();
		for(WebElement element: elements) {
			data.add(element.getText());
		}
		return data;
		
	}

}
