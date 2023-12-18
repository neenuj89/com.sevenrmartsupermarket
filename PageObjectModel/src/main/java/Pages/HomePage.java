package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
WebDriver driver;
By Logo = By.xpath("//a[@href='index.php']//img");

public void isLogoDisplayed() {
      WebElement element = driver.findElement(Logo);
      String genTitle = driver.getTitle();
      System.out.println(genTitle);
      System.out.println(element.isDisplayed());
}
public HomePage(WebDriver driver) {
this.driver=driver;
}
}
