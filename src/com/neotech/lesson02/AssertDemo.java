package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AssertDemo extends CommonMethods {

	//url=https://hrm.neotechacademy.com
	
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void titleValidation() {
		String expected = "OrangeHRM...";
		String actual = driver.getTitle();

		// 1st way
		// Assert.assertEquals(expected, actual);

		// 2nd way
		Assert.assertEquals(actual, expected, "Title does NOT MATCH!!!");

		// if assertion fails, anything after will not run
		System.out.println("This is the end of title validation test");
	}

	@Test
	public void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		boolean logoExists = logo.isDisplayed();

		// set it to false on purpose for Failing the test
		logoExists = false;

		// 1st way
		// Assert.assertEquals(logoExists, true);

		// 2nd way
		// Assert.assertEquals(logoExists, true, "Logo is NOT displayed!");

		// 3rd way
		Assert.assertTrue(logoExists, "Logo is NOT displayed!");
	}
}
