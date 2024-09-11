package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods{
	
	//We added @BeforeMethod and @AfterMethod in BaseClass at the top of setUp() and tearDown() methods
	//directly. They already apply since I am extending the CommonMethods.
	//So, no need to call them here again.
	
	@Test(dataProvider="userData")
	public void loginFunctionality(String username, String password)
	{
		sendText(driver.findElement(By.id("txtUsername")), username);
		sendText(driver.findElement(By.id("txtPassword")), password);
		
		click(driver.findElement(By.xpath("//button")));
	}
	
	
	//to create data driven tests in TestNG we use @DataProvider annotation
	
	@DataProvider(name="userData")
	public Object[][] getData()
	{
		
		//1st test: Admin,  Admin123  {"Admin", "Admin123"}
		//2nd test: Mona, Mona123	  {"Mona", "Mona123"}
		//3rd test: Nazli, Nazli123  {"Nazli", "Nazli123"}
		
		Object[][] credentials = {
									{"Admin", "Admin123"}, 
									{"Mona", "Mona123"}, 
									{"Nazli", "Nazli123"}};
		
		
		return credentials;
	}
	

}
