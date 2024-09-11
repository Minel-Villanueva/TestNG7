package com.neotech.lesson02;

import org.testng.annotations.Test;

public class PriorityDemo {

	@Test(priority = 1, groups="smoke")
	public void firstTest() {
		System.out.println("firstTest");
	}

	@Test(priority = 2)
	public void secondTest() {
		System.out.println("secondTest");
	}

	@Test                                  // if we dont write priority, it will be priority ZERO
	public void thirdTest() {
		System.out.println("thirdTest");
	}

	@Test(priority = 10)
	public void fourthTest() {
		System.out.println("fourthTest");
	}
}
