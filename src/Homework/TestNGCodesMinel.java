package Homework;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestNGCodesMinel {
	/*

CLASS 1 --------------------------


TestNG is an annotation based testing tool/framework

A testing framework is a set of guidelines and rules used for creating and designing test cases. A framework is a combination of practices and tools that are designed to help QA professionals test more efficiently.

TestNG is a tool seperate from Selenium, but we will use this tools together. 
-----------------------------
TestNG Installation:
-----------------------------
- This is done only once in Eclipse, not for every project!

Eclipse -> Help -> Marketplace -> Search TestNG -> Install
or
Eclipse -> Help -> Install New Software
Copy the link: https://testng.org/testng-eclipse-update-site
Select the checkbox and Finish. 
--------------------------------------------------
Steps to create the project:
We created a standard Java Project
We added the TestNG Library
Each time we use annotations, we have to import. 
We executed test cases using TestNG annotations with @Test
By default the test cases are executed in alphetical order


The most important annotations in TestNG is @Test. This is the real test case. 
We may have multiple @Test methods in our class. 
They are executed alphabetically (by default)

----------------------------------------------------
Before and After Annotation
Preconditions: (open browser, go to url....)
PostConditions: (close browser, generate reports...)
----------------------------------------------------
Reporting: 
- test-output folder (refresh)
- index.html
- emailable-report.html
---------------------------------------------------
When starting with Selenium:
- Add Selenium Jar files (later on we might need to add Common IO, Apache POI)
- Copy the configs folder
- Copy the com.neotech.utils package

---------------------------------------------------
What if we have more @Test methods??

Intuition: 

************NOT CORRECT************
BeforeClass
	BeforeMethod
		Test1
		Test2
	AfterMethod
AfterClass

************CORRECT************
BeforeClass
    BeforeMethod    -setUp()
        Test1
    AfterMethod     -tearDown()
    BeforeMethod    -setUp()
        Test2
    AfterMethod     -tearDown()
AfterClass

---------------------------------------------------

Suite
	Test1
	Test2
		Class1
		Class2
			Method1
			Method2
				TestCase1
				TestCase2
				....
				...


CLASS 2 ----------------------------------


TestNG is an open source framework/tool that helps us organize our test cases.
TestNG works with annotations
@Test - main annotation
@BeforeXXX - preconditions
@AfterXXX - postconditions
--------------------------------
Attributes

Different parameters/attributes to use with @Test
	priority
	enabled
	dependsOnMethods
	dependsOnGroups

In TestNG we can specify these attributes:

- priority of the test cases/test methods
	In TestNG test cases are executed in alphabetical order based on the name of the test methods.
	When do don't want to rely on that, we can use the priority attribute/parameter

	We can add the priority next to @Test
	Example : @Test(priority = 2)
	

- enable/disable the test cases
	By default all test cases are set to true for execution (enabled = true)
	If there is any test case that we want to skip(test case failed previously and the developers didn't fix the bug), we can do it by using enabled attribute and set it to false.

	If we dont want a test to run, we can add enabled = false next to @Test
    Example: @Test(enabled = false)


- dependency on other test cases
	If we want to set up dependency between test cases we can use dependsOnMethods attribute/parameter

	@Test(dependsOnMethods = { "firstTest", "secondTest" })  ---> IT MEANS THE TEST IS DEPENDS ON THE FIRST AND SECOND TEST SO THE FIRST AND SECOND SHOULD RUN FIRST.
	

	
--------------------------------
Assertions
To perform test validation in TestNG we use assertions.
	- Hard Assert uses Assert class and if it fails the execution of TC will stop
	
--------------------------------
In TestNG we have testng.xml file
Provides execution of multiple classes/packages/methods
We can configure which classes/packages/methods we want to execute

Why do we need testng.xml file
	To execute multiple methods in different packages/classes

Example:
<suite>
	<test>
		<classes>
			<class name="">
			<class name="">
		</classes>
	</test>

	<test>
		<classes>
			<class name="">
			<class name=""
			<class name=""
		</classes>
	</test>
</suite>

The testng.xml file will have following hierarchy
1.	The root tag of this file is <suite>.
2.	<suite> tag can contain one or more <test> tags.
3.	<test> tag can contain one or more <classes> and <packages> tags.


BY USING ASSERT, WE CAN GET RID OF IF METHOD;


      // 1st way
		// Assert.assertEquals(expected, actual);                             // HERE IF THE EXPECTED AND ACTUAL MATCH, THE RESULT WILL BE TEST PASSED
                                                                              // HERE IF THE EXPECTED AND ACTUAL NOT MATCH, THE RESULT WILL BE TEST FAILED
      // 2nd way
		// Assert.assertEquals(actual, expected, "Title does NOT MATCH!!!");  // HERE WE ALSO ADDED OUR CUSTOM MESSAGE

		// if assertion fails, anything after will not run

     // 3rd way
        // Assert.assertTrue(logoExists, "Logo is NOT displayed!");

Soft Assert;
    ----> - Soft Assert uses SoftAssert class and it will continue execution of TC even if assertion fails.
		    At the end of the TC we have to call assertAll() method --> This will collect all soft assertions and will decide if TC passed or failed

                  SoftAssert soft = new SoftAssert();
		          soft.assertTrue(logoExists, "Logo is NOT displayed!");
          
                  soft.assertAll();   -----> // this will collect all soft assertions
		                                     // and will decide whether the test passes or fails
                                             // If test case fails; execution will stop after assertAll() , otherwise, it will continue



TestNG CLASS 3

Include & Exclude

<include name="smoke"></include>
<exclude name="broken"></exclude>






















































































	 */
}
