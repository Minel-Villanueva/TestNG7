package com.neotech.lesson03;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AddEmployeeWithDataProvider extends CommonMethods {

	/*
	 	--- Add 3 Employees with using DataProvider  ---
		Open chrome browser and navigate to Orange HRM website
		Login with valid credentials
		Navigate to addEmployee tab
		Add 3 different employees using data Provider 
	 
	 */
	@Test(dataProvider="employees")
	public void adEmployee(String firstName, String lastName, String location)
	{
		//you can check if the data is coming properly from the data provider
		 System.out.println(firstName + " " + lastName + " " + location);
		 
		 
		 //login
		 
		 
		 //navigate to PIM menu
		 
		 
		 //click on Add Employee
		 
		 
		 //send employee data
		 
		 
		 //save employee
		 
		 
		 //validate employee is there (no need to search in the list, just check the personal details after save)
		 
	}
	

	@DataProvider(name="employees")
	public Object[][] employeeData()
	{
		//firstName, lastName, location
		
		Object[][] data = {};
		
		//fill out the data 2D
		
		
		return data;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

