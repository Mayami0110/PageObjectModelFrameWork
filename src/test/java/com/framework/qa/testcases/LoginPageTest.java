package com.framework.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.framework.qa.base.TestBase;
import com.framework.qa.pages.HomePage;
import com.framework.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initializations();
		
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		
		
		
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, prop.getProperty("loginTitle"));
	}
	
@Test(priority=1)
public void loginTest() {

	homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	
}

}
