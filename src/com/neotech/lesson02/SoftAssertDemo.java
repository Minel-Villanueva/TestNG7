package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class SoftAssertDemo extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void logoAndLoginValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		boolean logoExists = logo.isDisplayed();

		// set it to false on purpose for Failing the test
		logoExists = false;

		// logo validation
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(logoExists, "Logo is NOT displayed!");

		// login validation
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		wait(2);

		String expected = "Jacqueline White";
		String actual = driver.findElement(By.id("account-name")).getText();

		soft.assertEquals(actual, expected, "Account name is not Jacqueline White");

		// this will collect all soft assertions
		// and will decide whether the test passes or fails
		soft.assertAll();

		// If test case fails; execution will stop after assertAll()
		// otherwise, it will continue
		System.out.println("After assertAll() code");
	}

}
