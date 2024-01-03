package com.sevenrmartsupermarket.base;

import org.testng.annotations.DataProvider;

public class ValidUserLogins {
	@DataProvider(name="Valid User Credentials")
	public Object[][] Credentials()
	{
		return new Object [][] {{"pinky"," selenium"},{"Shameena"," Batch5"},{"ShameenaPS"," Batch5"}}; 
	}
}
