package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

//Homework 1: HRMS Application Negative Login: 
//
//    1. Open chrome browser
//    2. Go to "https://hrm.neotechacademy.com/"
//    3. Enter valid username
//    4. Leave password field empty
//    5. Verify error message with text "Password cannot be empty" is displayed.
//    
public class Homework1 extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void negativeLoginTest() {
		// we are writing Selenium test here
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), "");
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		wait(2);

		String expected = "Password cannot be empty";
		String actual = driver.findElement(By.id("txtPassword-error")).getText();

		if (actual.equals(expected)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test FAILED!!!");
		}
	}

	@Test
	public void loginValidation() {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		wait(2);
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

