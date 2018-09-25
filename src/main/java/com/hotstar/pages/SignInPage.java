package com.hotstar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.base.TestBase;

public class SignInPage extends TestBase{
	@FindBy(xpath="//h1[text()='Sign In']")
	public WebElement signInTitle;
	
	@FindBy(xpath="//div[@class='login-modal showLogin']//div[@class='close-btn']")
	public WebElement closeBtn;
	
	@FindBy(xpath="//span[text()='Sign In with Facebook']")
	public WebElement signInFBBtn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailTxtField;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passTxtField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Forgot Password']")
	WebElement forgotPassLink;
	
	@FindBy(xpath="//div[text()='Sign Up']")
	WebElement signUpLink;
	
	@FindBy(xpath="//p[text()='Please enter a valid email address']")
	WebElement emailErr;
	
	@FindBy(xpath="//p[text()='Please enter a password']")
	WebElement passErr;
	
	public SignInPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void verifyElements(){
		isElementPresent(signInTitle);
		isElementPresent(closeBtn);
		isElementPresent(signInFBBtn);
		isElementPresent(emailTxtField);
		isElementPresent(passTxtField);
		isElementPresent(submitBtn);
		isElementPresent(forgotPassLink);
		isElementPresent(signUpLink);
	}
}
