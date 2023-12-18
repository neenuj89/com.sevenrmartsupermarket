package Tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.TablePage;

public class TableTest extends BaseClass{

	TablePage tablePageObj;
	
	@Test
	public void launchTable() {
		tablePageObj =new TablePage(driver);
		tablePageObj.clickOnTable();
		
	}
	@Test
	public void verifyTableHeader() {
		tablePageObj=new TablePage(driver);
		tablePageObj.clickOnTable();
		String expecetdHeader="Table with Pagination Example";
		String actualHeader = tablePageObj.getTableHeader();
		Assert.assertEquals(actualHeader, expecetdHeader);
	}
	
	@Test
	public void printNames() {
		List<String> names =new ArrayList<String>();
		tablePageObj=new TablePage(driver);
		tablePageObj.clickOnTable();
	 names=tablePageObj.printAllNames();
		for(String name: names) {
			System.out.println(name);
		}
	}
	
	@Test
	public void verifyOffice() {
		tablePageObj=new TablePage(driver);
		tablePageObj.clickOnTable();
		String ofc =tablePageObj.getOffice("Airi Satou");
		System.out.println(ofc);
		
	}
	
}
