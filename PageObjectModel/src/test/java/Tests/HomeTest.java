package Tests;

import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.HomePage;

public class HomeTest extends BaseClass {
HomePage homepage;

@Test
public void verifyLogoPresent() {
homepage  = new HomePage(driver);
String genTitle = driver.getTitle();
System.out.println(genTitle);
homepage.isLogoDisplayed();
}
}