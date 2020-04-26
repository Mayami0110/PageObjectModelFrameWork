package com.framework.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.qa.base.TestBase;

public class HomePage extends TestBase {

	/*
	 * @FindBy(xpath="//span[contains(text(),'Mayank')]") WebElement nameLabel;
	 * 
	 * @FindBy(xpath ="//*[@id=\"nav-primary-contacts-branch\"]/text()") WebElement
	 * contacts;
	 */ //// td[contains(text(),'Manger Id : mgr123')]

	@FindBy(xpath = "//td[contains(text(),'Manger Id : mgr123')]")
	WebElement usernameLabel;

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomerLink;

	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement newAccountLink;

	@FindBy(xpath = "//a[contains(text(),'Deposit')]")
	WebElement DepositLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();

	}
	
	public boolean verifyCorrectUserName() {

		return usernameLabel.isDisplayed();
	

	}

	public NewCustomerPage clickOnNewCustomerLink() {

		newCustomerLink.click();
		return new NewCustomerPage();

	}

	public NewAccountPage clickOnNewAccountLink() {

		newAccountLink.click();
		return new NewAccountPage();

	}
	public DepositPage clickOnDepositLink() {

		DepositLink.click();
		return new DepositPage();

	}

}
