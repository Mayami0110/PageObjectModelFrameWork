package com.framework.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.qa.base.TestBase;
import com.framework.qa.pages.HomePage;
import com.framework.qa.pages.LoginPage;
import com.framework.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomer;
	
	public HomePageTest() {
		
		super();
	}
	
	//testcases should be independent from each other
	
	@BeforeMethod
	public void setup() {
		initializations();
		
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle= homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("homePageTitle"),"HomePageTitle is Not matching");
		
	}
	
	@Test(priority=-1)
	public void verifyUserNameTest() {
		
		Assert.assertTrue(homePage.verifyCorrectUserName(), "User Name is not Correct");
	}
	
	@Test()
	public void verifyNewCustomerTest() {
		
		newCustomer= homePage.clickOnNewCustomerLink();
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}

}
