package Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Utility {
	public String get_attirbute(WebElement element, String attribute) {
		
		return element.getAttribute(attribute);
		
	}
	public List<String> getTextOfElements(List<WebElement> elements) {
		List <String> data =new ArrayList<String>();
		for(WebElement element: elements) {
			data.add(element.getText());
		}
		return data;
		
	}

}
