package com.framework.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.qa.base.TestBase;

public class NewCustomerPage extends TestBase{

	@FindBy(xpath="//td/p[contains(text(),'Add New Customer')]")
	WebElement AddNewCustomerLabel;
	
	
	public NewCustomerPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyNewCustomerPageTitle() {

		return driver.getTitle();

	}
	public boolean verifyAddNewCustomerLabel()
	{
		return AddNewCustomerLabel.isDisplayed();
	}
	
	
}
