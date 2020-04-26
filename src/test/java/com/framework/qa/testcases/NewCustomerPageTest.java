package com.framework.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.qa.base.TestBase;
import com.framework.qa.pages.HomePage;
import com.framework.qa.pages.LoginPage;
import com.framework.qa.pages.NewCustomerPage;

public class NewCustomerPageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomer;

	
	public NewCustomerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializations();
		
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newCustomer= homePage.clickOnNewCustomerLink();

	}
	
	@Test(priority=1)
	public void verifyNewCustomerPageTitleTest() {
		
		String newCustomerTitle= newCustomer.verifyNewCustomerPageTitle();
		Assert.assertEquals(newCustomerTitle, prop.getProperty("NewCustomerPageTitle"),"NewCustomerTitle is Not matching");
	}
	
	@Test(priority=2)
	public void verifyAddNewCustomerLabelTest() {
		
		Assert.assertTrue(newCustomer.verifyAddNewCustomerLabel(), "Add New Customer Label is not Correct");
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
