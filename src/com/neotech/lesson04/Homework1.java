package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class Homework1 extends CommonMethods {

	
	/*
	 
	 	Open chrome browser
		Go to "https://hrm.neotechacademy.com/"
		Login to the application
		Add 3 different Employees and Create Login Details by providing:
		First Name
		Last Name
		Username
		Password
		Verify Employee has been added successfully and take screenshot (you must have 3 different screenshots)
		Close the browser
		Specify a group for this test case, add it into specific suite and execute from the xml file.
	 
	 
	 */
	
	@Test(dataProvider="excelData")
	public void addEmployee(String firstName, String lastName, String location, String userName, String password)
	{
		
		//login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		
		click(driver.findElement(By.xpath("//button")));
		
		//go to add employee
		
		click(driver.findElement(By.id("menu_pim_viewPimModule")));
		click(driver.findElement(By.id("menu_pim_addEmployee")));
		
		
		//wait for the add employee menu to show up
		
		waitForVisibility(By.id("first-name-box"));
		
		//enter new employee data
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);
		
		//get the employee id so that we can verify the employee added
		String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		
		selectDropdown(driver.findElement(By.id("location")), location);
		
		//activate and enter the login details
		
		// 		might not work
		click(driver.findElement(By.xpath("//div[@class='custom-control custom-switch']")));
		
		
		sendText(driver.findElement(By.id("username")), userName);
		sendText(driver.findElement(By.id("password")), password);
		sendText(driver.findElement(By.id("confirmPassword")), password);
		
		//save the employee
		
		wait(2);
		click(driver.findElement(By.id("modal-save-button")));
		
		//verify employee
		//changed to wait for the firstName text box because the empId element has the same ID as the one when 
		//we enter employee data
		waitForVisibility(By.id("firstName"));
		
		String actualEmpId = driver.findElement(By.id("employeeId")).getAttribute("value"); 
		
		Assert.assertEquals(actualEmpId, empId, "Employee ID's do not match!");
		
		//take screenshot
		
		
		
		//First Way: 
		/*
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(source, new File("screenshots/"+firstName+"_"+lastName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		*/
		
		//Second Way: 
		
		String fullName = firstName + "_" + lastName;
		takeScreenShot(fullName);
		
	}
	
	
	@DataProvider(name="getData")
	public Object[][] createData()
	{
		Object[][] data = {
		{"Emp01", "L_Emp01","Chinese Development Center", "employee0000000001","!emp0000000001"},
		{"Emp02", "L_Emp02","German Regional HQ", "employee0000000002","!emp0000000002"},
		{"Emp03", "L_Emp03","Indian Development Center", "employee0000000003","!emp0000000003"}
	};
		
		
		
		return data;
	}
	
	
	@DataProvider(name="excelData")
	public Object[][] getExcelData()
	{
		String filePath = System.getProperty("user.dir") + "/testdata/Excel.xlsx";
		String sheetName = "Employee";
		
		return ExcelUtility.excelIntoArray(filePath, sheetName);
	}
	
	
	
}
